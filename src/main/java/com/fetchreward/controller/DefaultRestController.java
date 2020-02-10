package com.fetchreward.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultRestController {
	@RequestMapping(value = "/sendGmail", method = RequestMethod.GET)
	ResponseEntity<?> sendGmail(@RequestBody List<String> list) {
		try {
			if (list == null || list.isEmpty())
				return new ResponseEntity<String>("The list should contains string of gmail", HttpStatus.BAD_REQUEST);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		Set<String> result = new HashSet<>();
		for (String s : list) {
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
		System.out.println("Filtered Email: " + result);

		return new ResponseEntity<Integer>(result.size(), HttpStatus.BAD_REQUEST);
	}
}
