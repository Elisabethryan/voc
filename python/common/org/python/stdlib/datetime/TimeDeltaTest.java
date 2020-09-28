package org.python.stdlib.datetime;

import static org.junit.Assert.*;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;
import org.python.types.Int;

import java.util.HashMap;
import java.util.Map;

public class TimeDeltaTest {
	
	
	@Test
	public void test_arguments() {
		
		
	    org.python.types.Int day1 = org.python.types.Int.getInt(30000);
	    org.python.types.Int seconds1 = org.python.types.Int.getInt(30000);
	    org.python.types.Int microseconds1 = org.python.types.Int.getInt(30000);
	    org.python.Object[] args1 = {day1, seconds1, microseconds1};
	    TimeDelta td = new TimeDelta(args1, Collections.EMPTY_MAP);
	    
	    org.python.types.Str microseconds_res = td.__microseconds__();
	    org.python.types.Str microseconds_ref = new org.python.types.Str("30000");
	    org.python.types.Str seconds_res = td.__seconds__();
	    org.python.types.Str seconds_ref = new org.python.types.Str("30000");
	    org.python.types.Str days_res = td.__days__();
	    org.python.types.Str days_ref = new org.python.types.Str("30000");

	    boolean result = (microseconds_res.equals(microseconds_ref)) && (seconds_res.equals(seconds_ref)) && (days_res.equals(days_ref));
	    assertTrue(result);
	   
	};

	
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
	    assertEquals(result, reference);
	 };
	 
	@Test
	public void test_min() {
	    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args = {arg1};
	    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
	    org.python.types.Str result = (org.python.types.Str) td_result.__min__();
	    org.python.types.Str reference = new org.python.types.Str("-999999999 days, 0:00:00");
	    assertEquals(result, reference);
	};
	
	@Test
	public void test_resolution() {
	    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args = {arg1};
	    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
	    org.python.types.Str result = (org.python.types.Str) td_result.__resolution__();
	    org.python.types.Str reference = new org.python.types.Str("0:00:00.000001");
	    assertEquals(result, reference);
	};
	
	@Test
	public void test_comparison() {
		
	    org.python.types.Int day1 = org.python.types.Int.getInt(3);
	    org.python.types.Int seconds1 = org.python.types.Int.getInt(3);
	    org.python.types.Int microseconds1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args1 = {day1, seconds1, microseconds1};
	    TimeDelta td_result1 = new TimeDelta(args1, Collections.EMPTY_MAP);
	    org.python.types.Str result1 = (org.python.types.Str) td_result1.total_seconds();
	    
	    org.python.types.Int day2 = org.python.types.Int.getInt(3);
	    org.python.types.Int seconds2 = org.python.types.Int.getInt(3);
	    org.python.types.Int microseconds2 = org.python.types.Int.getInt(3);
	    org.python.Object[] args2 = {day2, seconds2, microseconds2};
	    TimeDelta td_result2 = new TimeDelta(args2, Collections.EMPTY_MAP);
	    org.python.types.Str result2 = (org.python.types.Str) td_result2.total_seconds();
	    
	    org.python.types.Int day3 = org.python.types.Int.getInt(1);
	    org.python.types.Int seconds3 = org.python.types.Int.getInt(1);
	    org.python.types.Int microseconds3 = org.python.types.Int.getInt(1);
	    org.python.Object[] args3 = {day3, seconds3, microseconds3};
	    TimeDelta td_result3 = new TimeDelta(args3, Collections.EMPTY_MAP);
	    org.python.types.Str result3 = (org.python.types.Str) td_result3.total_seconds();
	    
	    boolean result_true = td_result1.__comparison__(td_result2);
	    boolean result_false = td_result1.__comparison__(td_result3);

	    assertTrue(result_true);
	    assertFalse(result_false);
	   
	};

	@Test
	public void test_division() {
		
	    long divider = 3;
		
	    org.python.types.Int day1 = org.python.types.Int.getInt(3);
	    org.python.types.Int seconds1 = org.python.types.Int.getInt(3);
	    org.python.types.Int microseconds1 = org.python.types.Int.getInt(3);
	    org.python.Object[] args1 = {day1, seconds1, microseconds1};
	    TimeDelta td_result1 = new TimeDelta(args1, Collections.EMPTY_MAP);
	    TimeDelta result1 =  td_result1.__division__(divider);
	    
	    org.python.types.Int day3 = org.python.types.Int.getInt(1);
	    org.python.types.Int seconds3 = org.python.types.Int.getInt(1);
	    org.python.types.Int microseconds3 = org.python.types.Int.getInt(1);
	    org.python.Object[] args3 = {day3, seconds3, microseconds3};
	    TimeDelta result3 = new TimeDelta(args3, Collections.EMPTY_MAP);
	   
	    boolean result = result1.__comparison__(result3);
	    assertTrue(result);
	   
	};
	@Test
	public void test_multiplication() {
		
	    long divider = 3;
		
	    org.python.types.Int day1 = org.python.types.Int.getInt(1);
	    org.python.types.Int seconds1 = org.python.types.Int.getInt(1);
	    org.python.types.Int microseconds1 = org.python.types.Int.getInt(1);
	    org.python.Object[] args1 = {day1, seconds1, microseconds1};
	    TimeDelta td_result1 = new TimeDelta(args1, Collections.EMPTY_MAP);
	    TimeDelta result1 =  td_result1.__multiplication__(divider);
	    
	    org.python.types.Int arg1 = org.python.types.Int.getInt(2);
	    org.python.types.Int arg2 = org.python.types.Int.getInt(2);
	    org.python.types.Int arg3 = org.python.types.Int.getInt(2);
	    org.python.types.Int arg4 = org.python.types.Int.getInt(2);
	    org.python.types.Int arg5 = org.python.types.Int.getInt(2);
	    org.python.types.Int arg6 = org.python.types.Int.getInt(2);
	    org.python.Object[] args = {arg1, arg2, arg3, arg4, arg5, arg6};
	    TimeDelta td_result2 = new TimeDelta(args, Collections.EMPTY_MAP);
	    TimeDelta result2 =  td_result2.__multiplication__(divider);
	    
	    System.out.print(result2);
	    
	    org.python.types.Int day3 = org.python.types.Int.getInt(3);
	    org.python.types.Int seconds3 = org.python.types.Int.getInt(3);
	    org.python.types.Int microseconds3 = org.python.types.Int.getInt(3);
	    org.python.Object[] args3 = {day3, seconds3, microseconds3};
	    TimeDelta result3 = new TimeDelta(args3, Collections.EMPTY_MAP);
	   
	    boolean result = result1.__comparison__(result3);
	    assertTrue(result);
	   
	};	
	
}
