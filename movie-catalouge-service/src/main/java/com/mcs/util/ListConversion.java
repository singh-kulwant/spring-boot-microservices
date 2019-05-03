package com.mcs.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class ListConversion {

	public static void main(String[] args) {

		listToArray();

		arrayToList();

	}

	private static void arrayToList() {
		int[] numArray = { 10, 20, 30 };
		List<Integer> list = Arrays.asList(ArrayUtils.toObject(numArray));
	}

	private static void listToArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		int[] array = ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
	}
}
