package com.miniprojects.TM02_proj1;

import java.util.Scanner;

public class VideoLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();

        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("=========");
            System.out.println("1. Add Videos:");
            System.out.println("2. Check Out Video:");
            System.out.println("3. Return Video:");
            System.out.println("4. Receive Rating:");
            System.out.println("5. List Inventory:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice(1..6): ");

            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.print("Enter the name of the video you want to add: ");
                        String name = scanner.nextLine();
                        videoStore.addVideo(name);
                        break;

                    case 2:
                        System.out.print("Enter the name of the video you want to check out: ");
                        name = scanner.nextLine();
                        videoStore.doCheckout(name);
                        break;

                    case 3:
                        System.out.print("Enter the name of the video you want to Return: ");
                        name = scanner.nextLine();
                        videoStore.doReturn(name);
                        break;

                    case 4:
                        System.out.print("Enter the name of the video you want to Rate: ");
                        name = scanner.nextLine();
                        System.out.print("Enter the rating for this video: ");
                        int rating = scanner.nextInt();
                        videoStore.receiveRating(name, rating);
                        break;

                    case 5:
                        videoStore.listInventory();
                        break;

                    case 6:
                        System.out.println("Exiting...!! Thanks for using the application.");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Press enter to continue.");
                scanner.nextLine(); // Consume newline
            }
        }
    }
}
