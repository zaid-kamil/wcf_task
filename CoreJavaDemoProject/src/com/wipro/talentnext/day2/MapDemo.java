package com.wipro.talentnext.day2;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// TODO what is the benefit of LinkedHashMap
		Map<Integer, String> data = new LinkedHashMap<>();
		data.put(1, "Raja");
		data.put(2, "Rajesh");
		data.put(3, "Arush");
		data.put(4, "Kamal");
		data.put(5, null);

		// keys
		for (Integer  k : data.keySet()) {
			System.out.println(k + " -> " + data.get(k));
		}
	}

}
