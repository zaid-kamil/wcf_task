package com.wipro.tm14_proj6;

import java.util.ArrayList;

public class StringOperations {
	public static void main(String[] args) {
		String S1 = "JAVAJAVA";
		String S2 = "VA";
		ArrayList<String> results = performOperations(S1, S2);
		System.out.println(results);
	}

	public static ArrayList<String> performOperations(String S1, String S2) {
		ArrayList<String> results = new ArrayList<>();

		// Operation 1: Replace characters at alternate indices of S1 with S2
		StringBuilder sb1 = new StringBuilder(S1);
		for (int i = 0; i < S1.length(); i += 2) {
			sb1.replace(i, i + 1, S2);
		}
		results.add(sb1.toString());

		// Operation 2: Replace the last occurrence of S2 in S1 with the reverse of S2
		if (S1.lastIndexOf(S2) != S1.indexOf(S2)) {
			StringBuilder sb2 = new StringBuilder(S1);
			int lastIndex = sb2.lastIndexOf(S2);
			sb2.replace(lastIndex, lastIndex + S2.length(), new StringBuilder(S2).reverse().toString());
			results.add(sb2.toString());
		} else {
			results.add(S1 + S2);
		}

		// Operation 3: Delete the first occurrence of S2 in S1
		if (S1.contains(S2) && S1.indexOf(S2) != S1.lastIndexOf(S2)) {
			StringBuilder sb3 = new StringBuilder(S1);
			int firstIndex = sb3.indexOf(S2);
			sb3.delete(firstIndex, firstIndex + S2.length());
			results.add(sb3.toString());
		} else {
			results.add(S1);
		}

		// Operation 4: Divide S2 into two halves and add to the beginning and end of S1
		int mid = (S2.length() + 1) / 2;
		String firstHalf = S2.substring(0, mid);
		String secondHalf = S2.substring(mid);
		results.add(firstHalf + S1 + secondHalf);

		// Operation 5: Replace characters in S1 that are in S2 with '*'
		StringBuilder sb5 = new StringBuilder(S1);
		for (int i = 0; i < S1.length(); i++) {
			if (S2.indexOf(S1.charAt(i)) != -1) {
				sb5.setCharAt(i, '*');
			}
		}
		results.add(sb5.toString());

		return results;
	}
}