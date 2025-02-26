package com.wipro.talentnext.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<Car>();
		Car c1 = new Car("Red");
		Car c2 = new Car("Black");
		Car c3 = new Car("Green");
		Car c4 = new Car("Yellow");
		Car c5 = new Car("Red");
		Car c6 = new Car("Blue");

		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);
		cars.add(c6);

		// for each
		System.out.println("=> Travesal using For each");
		for (Car car : cars) {
			System.out.println(car.getColor());
		}
		// enumeration
		// TODO test enumeration using .element()?

		// Iterator
		System.out.println("=> Travesal using Iterator");
		Iterator<Car> iterator = cars.iterator();
		while (iterator.hasNext()) {
			Car car = iterator.next();
			System.out.println(car.getColor());
		}
		
		// List Iteration
		System.out.println("=> Normal Traversal List Iteration");
		ListIterator<Car> iter = cars.listIterator();
		while(iter.hasNext()) {
			Car car = iter.next();
			if (car.getColor().equalsIgnoreCase("Red")) {
				iter.remove();
				continue;
			}
			System.out.println(car.getColor());
		}
		
		// List Iteration in reverse
		System.out.println("=> Reversed Traversal using List Iterator");
		ListIterator<Car> iter2 = cars.listIterator();
		while(iter.hasPrevious()) {
			System.out.println(iter.previous().getColor());
		}
	}

}
