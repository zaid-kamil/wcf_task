package com.wipro.talentnext.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.wipro.talentnext.dto.User;

public class WrapperDemo {
	public static void main(String[] args) {
		int a = 10;
		Integer i = 10; // Auto-boxing -> primitive Datatype automatically converted to object
		System.out.println(i); // Auto-unboxing is conversion of object to primitive Datatype
		
		// Collection
		List container = new ArrayList();
		container.add(1);
		container.add("bharvi");
		
		System.out.println(container);
		// Collection with Generic
		List<User> users = new ArrayList<User>();
		users.add(new User("Bharvi","1234"));	
		users.add(new User("Zaid","12345"));
		users.add(new User("Amna","2138"));
		users.add(new User("Akbar","21234"));
		
		System.out.println(users);
		
		// Collection with Wrapper class
		List<Integer> marks = new LinkedList<Integer>();
		marks.add(83);
		marks.add(63);
		marks.add(66);
		System.out.println(marks);
	}
}
