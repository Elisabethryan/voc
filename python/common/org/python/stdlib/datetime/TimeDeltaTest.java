package org.python.stdlib.datetime;

import static org.junit.Assert.*;
import java.util.Collections;

import org.junit.Test;

public class TimeDeltaTest {
	
	@Test
	public void test_total_seconds() {
		  org.python.types.Int arg1 = org.python.types.Int.getInt(3);
		  org.python.Object[] args = {arg1};
		  TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
		  org.python.types.Str result = td.total_seconds();
		  org.python.types.Str reference = new org.python.types.Str("259200.0");
		  assertEquals(result, reference);
	};
	
	@Test
	public void test_max() {
		org.python.types.Int arg1 = org.python.types.Int.getInt(3);
		org.python.Object[] args = {arg1};
		TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
		org.python.types.Str result = (org.python.types.Str) td_result.__max__();
	    org.python.types.Str reference = new org.python.types.Str("999999999 days, 23:59:59.999999");
	    System.out.println("max");
	    System.out.println(result);
	    System.out.println(reference);
	    assertEquals(result, reference);
	 };
	 
	@Test
	public void test_min() {
	    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args = {arg1};
	    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
	    org.python.types.Str result = (org.python.types.Str) td_result.__min__();
	    org.python.types.Str reference = new org.python.types.Str("-999999999 days, 0:00:00");
	    System.out.println("min");
	    System.out.println(result);
	    System.out.println(reference);
	    assertEquals(result, reference);
	};
	
	@Test
	public void test_resolution() {
	    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args = {arg1};
	    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
	    org.python.types.Str result = (org.python.types.Str) td_result.__resolution__();
	    org.python.types.Str reference = new org.python.types.Str("0:00:00.000001");
	    System.out.println("ref");
	    System.out.println(result);
	    System.out.println(reference);
	    assertEquals(result, reference);
	};
}
