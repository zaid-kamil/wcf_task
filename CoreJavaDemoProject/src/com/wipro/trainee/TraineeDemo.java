package com.wipro.trainee;

import java.util.Scanner;

import com.wipro.trainee.exception.TraineeNotFoundException;
import com.wipro.trainee.model.Trainee;
import com.wipro.trainee.service.TraineeService;

public class TraineeDemo {
	public static void main(String[] args) {
		TraineeService service = new TraineeService();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("📃Select an number =>");
				System.out.println("➡️1. Add");
				System.out.println("➡️2: List");
				System.out.println("➡️3. Search ID");
				System.out.println("➡️4. Exit");

				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					Trainee trainee = new Trainee();
					System.out.print("Enter Trainee ID:");
					trainee.setTid(Integer.parseInt(scanner.nextLine()));
					System.out.print("Enter Trainee Name:");
					trainee.setTraineeName(scanner.nextLine());
					System.out.print("Enter Trainee Course:");
					trainee.setCourseName(scanner.nextLine());
					System.out.print("Enter Trainee Mobile:");
					trainee.setMobileNumber(scanner.nextLine());
					System.out.print("Enter Trainee Email:");
					trainee.setEmail(scanner.nextLine());
					service.addTrainee(trainee);
					break;
				case 2:
					for (Trainee item : service.findAllTrainee()) {
						System.out.println(item);
					}
					break;
				case 3:
					System.out.println("Enter trainee ID:");
					int id = Integer.parseInt(scanner.nextLine());
					Trainee result;
					try {
						result = service.getTraineeByID(id);
						System.out.println(result);
					} catch (TraineeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.exit(0);
				default:
					System.err.println("⚠️enter valid option⚠️");
				}
			} while (true);
		}
	}
}
