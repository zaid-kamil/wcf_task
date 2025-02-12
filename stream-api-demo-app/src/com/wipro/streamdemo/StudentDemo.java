package com.wipro.streamdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.wipro.streamdemo.model.Student;

public class StudentDemo {

	public static void main(String[] args) {
		List<Student> listOfStudents = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish", "Ray", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 31, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 34, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Dev", "Sai", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Soni", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 77),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

		// 1. Find list of students whose first name starts with alphabet 'A'
		List<Student> listStuName = listOfStudents.stream().filter(student -> student.getFirstName().startsWith("A"))
				.collect(Collectors.toList());
		System.out.println("List of students whose name starts with letter A: " + listStuName);

		// 2. Group the students by department names
		Map<String, List<Student>> groupedByDepartment = listOfStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName));
		System.out.println("\nStudents grouped by department:");
		groupedByDepartment.forEach((dept, students) -> System.out.println(dept + " -> " + students));

		// 3. Find the total count of students using stream
		long studentCount = listOfStudents.stream().count(); // why not listOfStudent.size();
		System.out.println("\nTotal number of students: " + studentCount);

		// 4. Find the max age of a student
		int maxAge = listOfStudents.stream().mapToInt(Student::getAge).max().orElse(0);
		System.out.println("4. Maximum age of a student: " + maxAge);

		// 5. Find all unique department names
		Set<String> departmentNames = listOfStudents.stream().map(Student::getDepartmentName)
				.collect(Collectors.toSet());
		System.out.println("5. Unique department names: " + departmentNames);

		// 6. Find the count of students in each department
		Map<String, Long> countByDept = listOfStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
		System.out.println("6. Count of students in each department: " + countByDept);

		// 7. Find students whose age is less than 30
		List<Student> studentsBelow30 = listOfStudents.stream().filter(student -> student.getAge() < 30)
				.collect(Collectors.toList());
		System.out.println("7. Students whose age is less than 30: " + studentsBelow30);

		// 8. Find students whose rank is between 50 and 100
		List<Student> studentsRank50To100 = listOfStudents.stream()
				.filter(student -> student.getRank() >= 50 && student.getRank() <= 100).collect(Collectors.toList());
		System.out.println("8. Students with rank between 50 and 100: " + studentsRank50To100);

		// 9. Find average age of male and female students
		Map<String, Double> avgAgeByGender = listOfStudents.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println("9. Average age of male and female students: " + avgAgeByGender);

		// 10. Find the department with the maximum number of students
		String maxDept = countByDept.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.orElse("No department");
		System.out.println("10. Department with the most students: " + maxDept);

		// 11. Find students staying in Delhi and sort them by name
		List<Student> studentsInDelhi = listOfStudents.stream()
				.filter(student -> student.getCity().equalsIgnoreCase("Delhi"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		System.out.println("11. Students in Delhi sorted by name: " + studentsInDelhi);

		// 12. Find the average rank in all departments
		double avgRank = listOfStudents.stream().mapToInt(Student::getRank).average().orElse(0);
		System.out.println("12. Average rank across all departments: " + avgRank);

		// 13. Find the highest rank in each department
		Map<String, Optional<Student>> highestRankByDept = listOfStudents.stream().collect(Collectors
				.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparingInt(Student::getRank))));
		System.out.println("13. Highest rank in each department: " + highestRankByDept);

		// 14. Find the list of students and sort them by their rank
		List<Student> sortedByRank = listOfStudents.stream().sorted(Comparator.comparingInt(Student::getRank))
				.collect(Collectors.toList());
		System.out.println("14. Students sorted by rank: " + sortedByRank);

		// 15. Find the student who has the second rank
		Student secondRankStudent = listOfStudents.stream().sorted(Comparator.comparingInt(Student::getRank)).skip(1)
				.findFirst().orElse(null);
		System.out.println("15. Student with second rank: " + secondRankStudent);
	}

}
