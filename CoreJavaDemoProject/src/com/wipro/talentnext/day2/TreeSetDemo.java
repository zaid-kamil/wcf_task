package com.wipro.talentnext.day2;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		Set<Employee> emps = new TreeSet<Employee>();
		emps.add(new Employee(1, "Raj", null));
		emps.add(new Employee(1, "Prayag", null));
		emps.add(new Employee(1, "Suraj", null));
		
		for (Employee employee : emps) {
			System.out.println(emps);
		}
	}

}
