package com.in.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> convertToJson(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException {
		try (Scanner scanner = new Scanner(inputStream)) {
			String responseBody = scanner.useDelimiter("\\A").next();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(responseBody, HashMap.class);
		}
	}

	@SuppressWarnings("unchecked")
	public static String convertToJson(String search) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(search, HashMap.class);

		return map.get("search");
	}
}
