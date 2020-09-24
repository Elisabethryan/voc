package org.python.stdlib.datetime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

// Constructor test? (Different tests at creating DateTime object)
// Attribute tests? (Check that they are set correctly)
// Or are  done through all the other tests?


class DateTimeTest {
	
	@Test
	void test_date() {
		
	}
	
	@Test
	void test_today() {	
	}

	@Test
	void test__year__() {
		
	}
	
	@Test
	void test__month__() {
		
	}
	
	@Test
	void test__day__() {
		
	}
	
	@Test
	void test__hour__() {
		
	}
	
	@Test
	void test__minute_() {
		
	}
	
	@Test
	void test__second__() {
		
	}
	
	@Test
	void test__microsecond_() {
		
	}

	@Test
	void test_min() {
		DateTime dt = (DateTime) DateTime.__min__();	
		
		Assert.assertEquals((String) dt.year.toJava(), "1");
		Assert.assertEquals((String) dt.month.toJava(), "1");
		Assert.assertEquals((String) dt.day.toJava(), "1");
		Assert.assertEquals((String) dt.hour.toJava(), "0");
		Assert.assertEquals((String) dt.minute.toJava(), "0");
		Assert.assertEquals((String) dt.second.toJava(), "0");
		Assert.assertEquals((String) dt.microsecond.toJava(), "0");
	}
	
	@Test
	void test_max() {
		DateTime dt = (DateTime) DateTime.__max__();	
		
		Assert.assertEquals((String) dt.year.toJava(), "9999");
		Assert.assertEquals((String) dt.month.toJava(), "12");
		Assert.assertEquals((String) dt.day.toJava(), "31");
		Assert.assertEquals((String) dt.hour.toJava(), "23");
		Assert.assertEquals((String) dt.minute.toJava(), "59");
		Assert.assertEquals((String) dt.second.toJava(), "59");
		Assert.assertEquals((String) dt.microsecond.toJava(), "999999");
	}
	
	@Test
	void test_weekday() {
		
	}
	
	
}

	



