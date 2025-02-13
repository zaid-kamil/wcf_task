package com.wipro.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContactList {
	private HashMap<String, Integer> contacts;

	public ContactList() {
		contacts = new HashMap<>();
	}

	// Add a new contact
	public void addContact(String name, Integer phoneNumber) {
		contacts.put(name, phoneNumber);
	}

	// Check if name exists
	public boolean hasContact(String name) {
		return contacts.containsKey(name);
	}

	// Check if phone number exists
	public boolean hasPhoneNumber(Integer phoneNumber) {
		return contacts.containsValue(phoneNumber);
	}

	// Display all contacts using Iterator
	public void displayContacts() {
		System.out.println("\nContact List:");
		System.out.println("=============");

		Iterator<Map.Entry<String, Integer>> iterator = contacts.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.printf("Name: %-15s Phone: %d%n", entry.getKey(), entry.getValue());
		}
	}

	public static void main(String[] args) {
		ContactList contactList = new ContactList();

		// Adding some contacts
		contactList.addContact("John Doe", 49991212);
		contactList.addContact("Jane Smith", 49991214);
		contactList.addContact("Bob Wilson", 49991213);
		contactList.addContact("Alice Brown", 49991211);

		// Test key (name) existence
		String searchName = "John Doe";
		System.out.println("Is " + searchName + " in contacts? " + contactList.hasContact(searchName));
		System.out.println("Is 'Tom' in contacts? " + contactList.hasContact("Tom"));

		// Test value (phone number) existence
		Integer searchPhone = 87654321;
		System.out.println(
				"\nIs phone number " + searchPhone + " in contacts? " + contactList.hasPhoneNumber(searchPhone));
		System.out.println("Is phone number 99999999999 in contacts? " + contactList.hasPhoneNumber(49991212));

		// Display all contacts
		contactList.displayContacts();
	}
}