package com.wipro.talentnext.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<Car> cars = new HashSet<Car>();
		Car c1 =  new Car("Red");
		cars.add(c1);
		cars.add(c1);
		cars.add(new Car("Green"));
		cars.add(new Car("Black"));
		cars.add(new Car("Yellow"));
		cars.add(new Car("Purple"));
		
		for (Car car : cars) {
			System.out.println(car.getColor());
		}
		
		Set<Car> carsLinked = new LinkedHashSet<Car>();
		Car c11 =  new Car("Red");
		carsLinked.add(c11);
		carsLinked.add(c11);
		carsLinked.add(new Car("Green"));
		carsLinked.add(new Car("Black"));
		carsLinked.add(new Car("Yellow"));
		carsLinked.add(new Car("Purple"));
		
		for (Car car : carsLinked) {
			System.out.println(car.getColor());
		}
	}

}
