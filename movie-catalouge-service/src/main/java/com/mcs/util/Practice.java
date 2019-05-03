package com.mcs.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Practice {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>(); 
		  
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.add("D"); 
        list.add("E"); 
        
        //Iterator to traverse the list and remove
        
        System.out.println("Iterator");
        
        Iterator<String> i = list.iterator();
        
        do {
        	String v = i.next();
        	System.out.println(v);
        	if("C".equalsIgnoreCase(v)) {
        		i.remove();
        	}
		} while (i.hasNext());
        
      //Thread Safe List Iterator to traverse the list

        System.out.println("ListIterator");
        
        ListIterator<String> li = list.listIterator();
        
        do {
        	System.out.println(li.next());
		} while (li.hasNext());
        
	}

}
