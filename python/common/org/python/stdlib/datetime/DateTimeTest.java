
package org.python.stdlib.datetime;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.types.Int;
// Constructor test? (Different tests at creating DateTime object)
// Attribute tests? (Check that they are set correctly)
// Or are  done through all the other tests?


class DateTimeTest {
	
	@Test 
	void test_str() {
		org.python.types.Int year = org.python.types.Int.getInt(1);
		org.python.types.Int month = org.python.types.Int.getInt(2);
		org.python.types.Int day = org.python.types.Int.getInt(3);

		org.python.Object[] dateTimeArgs = { year, month, day };
		DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
		Assert.assertEquals(dateTime.__str__().toJava(), "0001-02-03 00:00:00");
		
		year = org.python.types.Int.getInt(1200);
		month = org.python.types.Int.getInt(2);
		day = org.python.types.Int.getInt(3);
		org.python.types.Int hour = org.python.types.Int.getInt(9);
		org.python.types.Int minute = org.python.types.Int.getInt(4);
		org.python.types.Int second = org.python.types.Int.getInt(5);
		org.python.types.Int mircrosecond = org.python.types.Int.getInt(1);
		
		Map<String, Object> kwargs = new HashMap<>();
		kwargs.put("year", year);
		kwargs.put("month", month);
		kwargs.put("day", day);
		kwargs.put("hour", hour);
		kwargs.put("minute", minute);
		kwargs.put("second", second);
		kwargs.put("microsecond", mircrosecond);
		
		dateTime = new DateTime(new org.python.Object[] {}, kwargs);
		Assert.assertEquals(dateTime.__str__().toJava(), "1200-02-03 09:04:05.000001");
		
	}
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
		
//		dunno if we should change Date.java but max year is 9999 instead of 999
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
		Assert.assertEquals(todayYear.toJava(), (long) today.getYear());
		
		org.python.Object todayMonth =  dateTimeToday.month;
		Assert.assertEquals(todayMonth.toJava(), (long) today.getMonth().getValue());
	
		org.python.Object todayDay =  dateTimeToday.day;
		Assert.assertEquals(todayDay.toJava(), (long) today.getDayOfMonth());
	
		org.python.Object todayHour=  dateTimeToday.hour;
		Assert.assertEquals(todayHour.toJava(), (long) today.getHour());
		
		org.python.Object todayMinute=  dateTimeToday.minute;
		Assert.assertEquals(todayMinute.toJava(), (long) today.getMinute());
		
		org.python.Object todaySecond=  dateTimeToday.second;
		Assert.assertEquals(todaySecond.toJava(), (long) today.getSecond());
		
		long microSeconds = (long) Math.log10((long) (today.getNano() * 0.0010));
		long todayMicroSecond=  (long)Math.log10( (double) ((long)dateTimeToday.microsecond.toJava()));
		Assert.assertEquals(todayMicroSecond, microSeconds);
		
		
	}


	@Test
	void test_year() {
		for (long year = 1; year <= 9999L; ++year) {
			var py_year = Int.getInt(year);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(1);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day }, Collections.emptyMap());
			Assert.assertEquals(year, dt.year.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(year, dt.year.toJava());
		}
	}
	
	@Test
	void test_month() {
		for (long month = 1; month <= 12; ++month) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(month);
			var py_day = Int.getInt(1);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day }, Collections.emptyMap());
			Assert.assertEquals(month, dt.month.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(month, dt.month.toJava());
		}
	}
	
	@Test
	void test_day() {
		for (long day = 1; day <= 31; ++day) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(day);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day }, Collections.emptyMap());
			Assert.assertEquals(day, dt.day.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(day, dt.day.toJava());
		}
	}
	
	@Test
	void test_hour() {
		for (long hour = 0; hour <= 23; ++hour) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(1);
			var py_hour = Int.getInt(hour);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day, py_hour },
					Collections.emptyMap());
			Assert.assertEquals(hour, dt.hour.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);
			kwargs.put("hour", py_hour);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(hour, dt.hour.toJava());
		}
	}
	
	@Test
	void test__minute_() {
		for (long minute = 0; minute <= 59; ++minute) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(1);
			var py_hour = Int.getInt(0);
			var py_minute = Int.getInt(minute);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day, py_hour, py_minute },
					Collections.emptyMap());
			Assert.assertEquals(minute, dt.minute.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);
			kwargs.put("minute", py_minute);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(minute, dt.minute.toJava());
		}
	}
	
	@Test
	void test_second() {
		for (long second = 0; second <= 59; ++second) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(1);
			var py_hour = Int.getInt(0);
			var py_minute = Int.getInt(0);
			var py_second = Int.getInt(second);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day, py_hour, py_minute, py_second },
					Collections.emptyMap());
			Assert.assertEquals(second, dt.second.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);
			kwargs.put("second", py_second);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(second, dt.second.toJava());
		}
	}
	
	@Test
	void test_microsecond() {
		for (long microsecond = 0; microsecond <= 9999; ++microsecond) {
			var py_year = Int.getInt(1970);
			var py_month = Int.getInt(1);
			var py_day = Int.getInt(1);
			var py_hour = Int.getInt(0);
			var py_minute = Int.getInt(0);
			var py_second = Int.getInt(0);
			var py_microsecond = Int.getInt(microsecond);

			// Test using args
			var dt = new DateTime(new org.python.Object[] { py_year, py_month, py_day, py_hour, py_minute, py_second,
					py_microsecond }, Collections.emptyMap());
			Assert.assertEquals(microsecond, dt.microsecond.toJava());

			// Test using kwargs
			Map<String, Object> kwargs = new HashMap<>();
			kwargs.put("year", py_year);
			kwargs.put("month", py_month);
			kwargs.put("day", py_day);
			kwargs.put("microsecond", py_microsecond);

			dt = new DateTime(new org.python.Object[] {}, kwargs);
			Assert.assertEquals(microsecond, dt.microsecond.toJava());
		}
	}

	@Test
	void test_min() {
		DateTime dt = (DateTime) DateTime.__min__();	
		
		Assert.assertEquals(dt.year.toJava(), 1L);
		Assert.assertEquals(dt.month.toJava(), 1L);
		Assert.assertEquals(dt.day.toJava(), 1L);
		Assert.assertEquals(dt.hour.toJava(), 0L);
		Assert.assertEquals(dt.minute.toJava(), 0L);
		Assert.assertEquals(dt.second.toJava(), 0L);
		Assert.assertEquals(dt.microsecond.toJava(), 0L);
	}
	
	@Test
	void test_max() {
		DateTime dt = (DateTime) DateTime.__max__();	
		
		Assert.assertEquals(dt.year.toJava(), 9999L);
		Assert.assertEquals(dt.month.toJava(), 12L);
		Assert.assertEquals(dt.day.toJava(), 31L);
		Assert.assertEquals(dt.hour.toJava(), 23L);
		Assert.assertEquals(dt.minute.toJava(), 59L);
		Assert.assertEquals(dt.second.toJava(), 59L);
		Assert.assertEquals(dt.microsecond.toJava(), 999999L);
	}
	
	@Test
	void test_weekday() {

			for(int i = 0; i < 7; i++) {
				
			org.python.types.Int dateTimeYear = org.python.types.Int.getInt(2020);
			org.python.types.Int dateTimeMonth = org.python.types.Int.getInt(9);
			org.python.types.Int dateTimeDay = org.python.types.Int.getInt(28 - i);
			org.python.Object[] dateTimeArgs = { dateTimeYear, dateTimeMonth, dateTimeDay };
			DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
			
			Calendar cal = Calendar.getInstance();	
			cal.set(2020,9 - 1 ,28 - i);
		  
			int[] convertToPython = { 6, 0, 1, 2, 3, 4, 5 };
			int javaWeekday =  cal.get(Calendar.DAY_OF_WEEK);    
			org.python.Object weekday = dateTime.weekday();
			Assert.assertEquals(weekday.toJava(), (long) convertToPython[javaWeekday - 1]);

			}		
	}
	@Test 
	void test_ctime(){
		org.python.types.Int year = org.python.types.Int.getInt(2020);
		org.python.types.Int month = org.python.types.Int.getInt(9);
		org.python.types.Int day = org.python.types.Int.getInt(28);
		org.python.types.Int hour = org.python.types.Int.getInt(9);
		org.python.types.Int minute = org.python.types.Int.getInt(4);
		org.python.types.Int second = org.python.types.Int.getInt(5);
		
		org.python.Object[] dateTimeArgs = { year, month, day, hour, minute, second };
		DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
		dateTime.ctime();		
		Assert.assertEquals(dateTime.ctime().toJava(),"Mon Sep  28 09:04:05 2020");
		
		
		
		year = org.python.types.Int.getInt(1);
		month = org.python.types.Int.getInt(11);
		day = org.python.types.Int.getInt(4);
		hour = org.python.types.Int.getInt(12);
		minute = org.python.types.Int.getInt(43);
		second = org.python.types.Int.getInt(55);
		
		org.python.Object[] dateTimeArgs2 = { year, month, day, hour, minute, second };
		dateTime = new DateTime(dateTimeArgs2, Collections.emptyMap());
		dateTime.ctime();
		Assert.assertEquals(dateTime.ctime().toJava(),"Fri Nov  04 12:43:55 0001");
		
		
		
		year = org.python.types.Int.getInt(1);
		month = org.python.types.Int.getInt(1);
		day = org.python.types.Int.getInt(1);
		hour = org.python.types.Int.getInt(0);
		minute = org.python.types.Int.getInt(0);
		second = org.python.types.Int.getInt(0);
		
		org.python.Object[] dateTimeArgs3 = { year, month, day, hour, minute, second };
		dateTime = new DateTime(dateTimeArgs3, Collections.emptyMap());
		dateTime.ctime();
		Assert.assertEquals(dateTime.ctime().toJava(),"Sat Jan  01 00:00:00 0001");
		
		
	}
//	String input = "2012-22-01";
//	String input = "2011-11-04T00:05:23.987";
	@Test
	void test_fromisoformat() {
		DateTime dtIso = DateTime.fromisoformat(new org.python.types.Str("2012-12-01"));
		
		org.python.types.Int year = org.python.types.Int.getInt(2012);
		org.python.types.Int month = org.python.types.Int.getInt(12);
		org.python.types.Int day = org.python.types.Int.getInt(1);

		org.python.Object[] dateTimeArgs = { year, month, day };
		DateTime dateTime = new DateTime(dateTimeArgs, Collections.emptyMap());
		
		Assert.assertEquals(dtIso.year.toJava(), dateTime.year.toJava());
		Assert.assertEquals(dtIso.month.toJava(), dateTime.month.toJava());
		Assert.assertEquals(dtIso.day.toJava(), dateTime.day.toJava());
		Assert.assertEquals(dtIso.hour.toJava(), dateTime.hour.toJava());
		Assert.assertEquals(dtIso.minute.toJava(),dateTime.minute.toJava());
		Assert.assertEquals(dtIso.second.toJava(), dateTime.second.toJava());
		Assert.assertEquals(dtIso.microsecond.toJava(), dateTime.microsecond.toJava());

	
		dtIso = DateTime.fromisoformat(new org.python.types.Str("2011-11-04T00:05:23.987"));
	
		 year = org.python.types.Int.getInt(2011);
		 month = org.python.types.Int.getInt(11);
		 day = org.python.types.Int.getInt(4);
		 org.python.types.Int hour = org.python.types.Int.getInt(0);
		 org.python.types.Int minute = org.python.types.Int.getInt(5);
		 org.python.types.Int second = org.python.types.Int.getInt(23);
		 org.python.types.Int microsecond = org.python.types.Int.getInt(987000);
		 
		org.python.Object[] dateTimeArgs2 = { year, month, day, hour, minute, second, microsecond };
		 dateTime = new DateTime(dateTimeArgs2, Collections.emptyMap());
		
		Assert.assertEquals(dtIso.year.toJava(), dateTime.year.toJava());
		Assert.assertEquals(dtIso.month.toJava(), dateTime.month.toJava());
		Assert.assertEquals(dtIso.day.toJava(), dateTime.day.toJava());
		Assert.assertEquals(dtIso.hour.toJava(), dateTime.hour.toJava());
		Assert.assertEquals(dtIso.minute.toJava(),dateTime.minute.toJava());
		Assert.assertEquals(dtIso.second.toJava(), dateTime.second.toJava());
		Assert.assertEquals(dtIso.microsecond.toJava(), dateTime.microsecond.toJava());
	
		
		dtIso = DateTime.fromisoformat(new org.python.types.Str("2011-11-04 00:05:23.987"));
		
		Assert.assertEquals(dtIso.year.toJava(), dateTime.year.toJava());
		Assert.assertEquals(dtIso.month.toJava(), dateTime.month.toJava());
		Assert.assertEquals(dtIso.day.toJava(), dateTime.day.toJava());
		Assert.assertEquals(dtIso.hour.toJava(), dateTime.hour.toJava());
		Assert.assertEquals(dtIso.minute.toJava(),dateTime.minute.toJava());
		Assert.assertEquals(dtIso.second.toJava(), dateTime.second.toJava());
		Assert.assertEquals(dtIso.microsecond.toJava(), dateTime.microsecond.toJava());
		
	}
	
	
	
}

	
