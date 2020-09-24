package org.python.stdlib.datetime;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.python.Object;

// Constructor test? (Different tests at creating DateTime object)
// Attribute tests? (Check that they are set correctly)
// Or are  done through all the other tests?


class DateTimeTest {
	
	@Test
	void test_date() {
		org.python.types.Int dateTimeYear = org.python.types.Int.getInt(1);
		org.python.types.Int dateTimeMonth = org.python.types.Int.getInt(2);
		org.python.types.Int dateTimeDay = org.python.types.Int.getInt(3);

		org.python.Object[] dateTimeArgs = { dateTimeYear, dateTimeMonth, dateTimeDay };
		DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
		Date dateTimeDate = (Date) dateTime.date();
		
		org.python.types.Int dateYear = org.python.types.Int.getInt(1);
		org.python.types.Int dateMonth = org.python.types.Int.getInt(2);
		org.python.types.Int dateDay = org.python.types.Int.getInt(3);

		org.python.Object[] dateArgs = { dateYear, dateMonth, dateDay };
		Date date = new Date(dateArgs, Collections.emptyMap());
		
		Assert.assertEquals(dateTimeDate.year, date.year );
		Assert.assertEquals(dateTimeDate.month, date.month );
		Assert.assertEquals(dateTimeDate.day, date.day );
	}
	
	@Test
	void test_today() {	
		org.python.types.Int year = org.python.types.Int.getInt(1);
		org.python.types.Int month = org.python.types.Int.getInt(2);
		org.python.types.Int day = org.python.types.Int.getInt(3);

		org.python.Object[] args = { year, month, day };
		DateTime dateTime = new DateTime(args, Collections.emptyMap());
		DateTime dateTimeToday = (DateTime) dateTime.today();
		
		java.time.LocalDateTime today = java.time.LocalDateTime.now();

				
		org.python.Object todayYear =  dateTimeToday.year;
		Assert.assertEquals(todayYear.toJava(), Integer.toString(today.getYear()));
		
		org.python.Object todayMonth =  dateTimeToday.month;
		Assert.assertEquals(todayMonth.toJava(), Integer.toString(today.getMonth().getValue()));
	
		org.python.Object todayDay =  dateTimeToday.day;
		Assert.assertEquals(todayDay.toJava(), Integer.toString(today.getDayOfMonth()));
	
		org.python.Object todayHour=  dateTimeToday.hour;
		Assert.assertEquals(todayHour.toJava(), Integer.toString(today.getHour()));
		
		org.python.Object todayMinute=  dateTimeToday.minute;
		Assert.assertEquals(todayMinute.toJava(), Integer.toString(today.getMinute()));
		
		org.python.Object todaySecond=  dateTimeToday.second;
		Assert.assertEquals(todaySecond.toJava(), Integer.toString(today.getSecond()));
		
//		Testing only the most significant number since it will change during execution time. 
		org.python.Object todayMicroSecond=  dateTimeToday.microsecond;
		int microSeconds = (int) (today.getNano() * 0.0010);
		char microSecondsChar = Integer.toString(microSeconds).charAt(0);
		String microSecondMostSignificantNumber = String.valueOf(microSecondsChar);
		
		String todayMethodString = (String) todayMicroSecond.toJava();
		char todayMethodChar =todayMethodString.charAt(0);
		String todayMethodMostSignificantNumber = String.valueOf(todayMethodChar);
		Assert.assertEquals(todayMethodMostSignificantNumber, microSecondMostSignificantNumber);
								
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
		org.python.types.Int dateTimeYear = org.python.types.Int.getInt(1);
		org.python.types.Int dateTimeMonth = org.python.types.Int.getInt(2);
		org.python.types.Int dateTimeDay = org.python.types.Int.getInt(3);

		org.python.Object[] dateTimeArgs = { dateTimeYear, dateTimeMonth, dateTimeDay };
		DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
		
		java.time.LocalDateTime today = java.time.LocalDateTime.now();
		org.python.Object weekday = dateTime.weekday();
		
		Assert.assertEquals(weekday.toJava(), today.getDayOfWeek().getValue());
		
		
	}
	
	
}

	



