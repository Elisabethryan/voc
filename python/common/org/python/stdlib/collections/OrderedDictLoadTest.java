package org.python.stdlib.collections;

import org.jbenchx.annotations.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.python.Object;
import org.python.types.List;
import org.python.types.Str;

@RunWith(JUnitPlatform.class)
public class OrderedDictLoadTest {
	public static void main(String[] args) {
		//System.out.print("Start\n");
		
		List tuple_list = new List();
		
		
		for (int i = 0; i < 1000000; i++) {
			ArrayList<org.python.Object> tuple = new ArrayList<>(2);
			tuple.add(new Str(Integer.toString(i)));
			tuple.add(org.python.types.Int.getInt(i));
			tuple_list.append(new org.python.types.Tuple(tuple));
		}
		
		org.python.Object[] args2 = { tuple_list };
		HashMap<String, Object> kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

		OrderedDict dict = new OrderedDict(args2, kwargs2);
		
		OrderedDict copy = (OrderedDict)dict.copy();
		
		String str = copy.toString();
	}

}
