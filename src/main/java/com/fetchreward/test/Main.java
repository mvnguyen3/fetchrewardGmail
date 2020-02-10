package com.fetchreward.test;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		Set<String> result = new HashSet<String>();
		set.add("test.email@gmail.com");
		set.add("test.email+spam@gmail.com");
		set.add("testemail@gmail.com");

		for (String s : set) {

			if (!s.contains(".") && !s.contains("+")) {
				result.add(s);
			} else {
				if (s.contains(".")) {
					s = s.replaceAll("\\.", "");
					s = s.replace("@gmailcom", "@gmail.com");
				}
				if (s.contains("+")) {
					int plusIndex = s.indexOf("+");
					s = s.substring(0, plusIndex);
					if (!s.contains("@gmail.com"))
						s += "@gmail.com";
				}
				result.add(s);
			}

		}
		System.out.println("Original set: " + set);
		System.out.println("Filtered: " + result);
	}
}
