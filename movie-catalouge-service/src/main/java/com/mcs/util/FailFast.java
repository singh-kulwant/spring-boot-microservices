package com.mcs.util;

import java.util.ArrayList;

public class FailFast {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>(); 
		  
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.add("D"); 
        list.add("E"); 
        
        list.stream()
		.filter("C"::equals)
		.forEach(list::remove);
	}
}
