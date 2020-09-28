package org.python.stdlib.datetime;

import org.junit.Test;
import static org.junit.Assert.*;
import org.python.stdlib.datetime.Date;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.python.Object;
import org.python.exceptions.SyntaxError;
import org.python.exceptions.TypeError;
import org.python.exceptions.ValueError;
import org.python.types.*;

public class DateTest {

    Map<String, Object> null_kwargs = Collections.emptyMap();
    protected void setUp() {
        //Probably never going to be used?
    }

    //Tests for value error exceptions 
    @Test(expected = ValueError.class)
    public void testValueError() {
        //Testing ranges on year
        Map<String, Object> kwargs = new HashMap<>();
        kwargs.put("year", Int.getInt(1000));
        kwargs.put("month", Int.getInt(10));
        kwargs.put("day", Int.getInt(10));
        new Date(new Object[] {}, kwargs);
        kwargs.replace("year", Int.getInt(100));
        new Date(new Object[] {}, kwargs);
        kwargs.replace("year", Int.getInt(10));
        new Date(new Object[] {}, kwargs);
        kwargs.replace("year", Int.getInt(0));
        new Date(new Object[] {}, kwargs);

        //Testing ranges on month
        new Date(new Object[] {}, kwargs);
        kwargs.replace("month", Int.getInt(13));
        new Date(new Object[] {}, kwargs);
        kwargs.replace("month", Int.getInt(0)); //prob can remove this
        new Date(new Object[] {}, kwargs);

        //Testing ranges on day
        kwargs.replace("month", Int.getInt(0));
        new Date(new Object[] {}, kwargs);
        kwargs.replace("month", Int.getInt(32));
        new Date(new Object[] {}, kwargs);

        //Negative values
        Map<String, Object> null_kwargs = Collections.emptyMap();
        new Date(new Object[] {Int.getInt(-2020), Int.getInt(9), Int.getInt(23)}, null_kwargs);
        new Date(new Object[] {Int.getInt(2020), Int.getInt(-9), Int.getInt(23)}, null_kwargs);
        new Date(new Object[] {Int.getInt(-2020), Int.getInt(9), Int.getInt(-23)}, null_kwargs);
    }


    //Tests for type error exceptions 
    @Test(expected = TypeError.class)
    public void testTypeError() {
        Map<String, Object> null_kwargs = Collections.emptyMap();

        //No supploed argument
        new Date(new Object[] {}, null_kwargs);

        //Too many arguments supplied
        Map<String, Object> kwargs1 = new HashMap<>();
        kwargs1.put("year", Int.getInt(10));
        kwargs1.put("month", Int.getInt(10));
        kwargs1.put("day", Int.getInt(10));
        new Date(new Object[] {Int.getInt(10)}, kwargs1);
        
        //Incorrect year type
        Map<String, Object> kwargs2 = new HashMap<>();
        kwargs2.put("year", new org.python.types.Str("5"));
        kwargs2.put("month", Int.getInt(10));
        kwargs2.put("day", Int.getInt(10));
        new Date(new Object[] {}, kwargs2);

        //Incorrect month type
        kwargs2.replace("month", new org.python.types.Str("10"));
        new Date(new Object[] {}, kwargs2);

        //Incorrect day type
        kwargs2.replace("day", new org.python.types.Str("10"));
        new Date(new Object[] {}, kwargs2);

        //Empty argument values
        Map<String, Object> kwargs3 = new HashMap<>();
        //Empty year
        kwargs3.put("year", new org.python.types.Str(""));
        kwargs3.put("month", Int.getInt(10));
        kwargs3.put("day", Int.getInt(10));
        //Empty month 
        new Date(new Object[] {}, kwargs3);
        kwargs3.replace("year", Int.getInt(10));
        kwargs3.replace("month", new org.python.types.Str(""));
        //Empty day 
        new Date(new Object[] {}, kwargs3);
        kwargs3.replace("month", Int.getInt(10));
        kwargs3.replace("day", new org.python.types.Str(""));

        //TODO: Try for all number of supplied arguments?

    }


    //Tests for syntax error exceptions 
    @Test(expected = SyntaxError.class)
    public void testSyntaxError() {

        //Mixing keyword argument with positional argument.
        Map<String, Object> kwargs = new HashMap<>();
        kwargs.put("year", Int.getInt(10));
        new Date(new Object[] {Int.getInt(10), Int.getInt(10)}, kwargs);
        kwargs.put("month", Int.getInt(10));
        new Date(new Object[] {Int.getInt(10)}, kwargs);

        Map<String, Object> kwargs1 = new HashMap<>();
        kwargs1.put("day", Int.getInt(10));
        new Date(new Object[] {Int.getInt(10), Int.getInt(10)}, kwargs1);

    }


    @Test
    public void testRepr() {
       Date testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(3)}, null_kwargs); 
       Assert.assertEquals(testDate1.__repr__(), new org.python.types.Str("0001-02-03"));

       Date testDate2 = new Date(new Object[] {Int.getInt(10), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate2.__repr__(), new org.python.types.Str("0010-10-30"));

       Date testDate3 = new Date(new Object[] {Int.getInt(100), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate3.__repr__(), new org.python.types.Str("0100-10-30"));

       Date testDate4 = new Date(new Object[] {Int.getInt(1000), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate4.__repr__(), new org.python.types.Str("1000-10-30"));
    }

    @Test(expected = ValueError.class)
    public void testYear() {
       Date testValidYear = new Date(new Object[] {Int.getInt(2020), Int.getInt(1), Int.getInt(1)}, null_kwargs);
       Assert.assertEquals(testValidYear.__year__(), new org.python.types.Str("2020"));
       
       Date testEdgeCaseYear = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
       Assert.assertEquals(testEdgeCaseYear.__year__(), new org.python.types.Str("1"));
       
       // TODO: maybe should be moved to own method. Otherwise code above could pass if it throws ValueError even if it shouldn't.
       Date testInvalidYear = new Date(new Object[] {Int.getInt(0), Int.getInt(1), Int.getInt(1)}, null_kwargs);
       Assert.assertEquals(testInvalidYear.__year__(), new org.python.types.Str("0"));
    }

    @Test
    public void testMonth() {
       Date testDate1 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Date testDate2 = new Date(new Object[] {Int.getInt(0), Int.getInt(9), Int.getInt(0)}, null_kwargs);
       Assert.assertEquals(testDate1.__month__(), new org.python.types.Str(""));
       Assert.assertEquals(testDate2.__month__(), new org.python.types.Str("2020"));
    }

    @Test
    public void testDay() {
       Date testDate1 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Date testDate2 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(25)}, null_kwargs);
       Assert.assertEquals(testDate1.__day__(), new org.python.types.Str(""));
       Assert.assertEquals(testDate2.__day__(), new org.python.types.Str("25"));
    }

    @Test
    public void testMax() {
        Date testDate = (Date) Date.__max__();
        Assert.assertEquals(testDate.year, Int.getInt(9999));
        Assert.assertEquals(testDate.month, Int.getInt(12));
        Assert.assertEquals(testDate.day, Int.getInt(31));
    }

    @Test
    public void testMin() {
        Date testDate = (Date) Date.__min__();
        Assert.assertEquals(testDate.year, Int.getInt(1));
        Assert.assertEquals(testDate.month, Int.getInt(1));
        Assert.assertEquals(testDate.day, Int.getInt(1));
    }


    @Test
    public void testToday() {
        Date dateTodayTest = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(3)}, null_kwargs);
        Date date = (Date) dateTodayTest.today();
        java.time.LocalDateTime actualToday = java.time.LocalDateTime.now();
        //may need some toJavas here
        org.python.Object yearNow = date.year;
        Assert.assertEquals(yearNow, (long) actualToday.getYear());
        org.python.Object monthNow = date.month;
        Assert.assertEquals(monthNow, (long) actualToday.getMonth().getValue());
        org.python.Object dayNow = date.day;
        Assert.assertEquals(dayNow, (long) actualToday.getDayOfMonth());
        
    }

    @Test
    public void testCtime() {
        Date testDate = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertEquals(testDate.ctime(), new org.python.types.Str("Mon Jan 1 00:00:00 1"));
    }

    @Test
    public void testWeekday() {
    	// Try "edge cases" with Sundays and Mondays first which are represented differently in Python and Java
    	// The 5th of January 2020 is a Sunday, the 6th day in Python
        Date pythonSunday = new Date(new Object[] {Int.getInt(2020), Int.getInt(1), Int.getInt(5)}, null_kwargs);
        Assert.assertEquals(pythonSunday.weekday().toJava(), (long)6);
        
        // The 6th of January 2020 is a Monday, the 0th day in Python
        Date pythonMonday = new Date(new Object[] {Int.getInt(2020), Int.getInt(1), Int.getInt(6)}, null_kwargs);
        Assert.assertEquals(pythonMonday.weekday().toJava(), (long)0);
        
        // The 7th of January 2020 is a Tuesday, the 1st day in Python
        Date pythonTuesday = new Date(new Object[] {Int.getInt(2020), Int.getInt(1), Int.getInt(7)}, null_kwargs);
        Assert.assertEquals(pythonTuesday.weekday().toJava(), (long)1);
    }


   //helper function to make assert work
    public java.lang.Boolean helpEq(org.python.Object obj1, org.python.Object obj2) {
        return ((Bool) obj1.__eq__(obj2)).value;
    }

    @Test
    public void test_eq() {

        //Two instances of equivalent attribute values
        Date testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Date testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertTrue(helpEq(testDate1, testDate2));
        Assert.assertTrue(helpEq(testDate2, testDate1));

        //Test for inequal objects
        testDate2 = new Date(new Object[] {Int.getInt(2), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertFalse(helpEq(testDate1, testDate2));
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(1)}, null_kwargs);
        Assert.assertFalse(helpEq(testDate1, testDate2));
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(2)}, null_kwargs);
        Assert.assertFalse(helpEq(testDate1, testDate2));

        //Test for same instance
        Assert.assertTrue(helpEq(testDate1, testDate1));
    }


   //helper function to make assert work
    public java.lang.Boolean helpLt(org.python.Object obj1, org.python.Object obj2) {
        return ((Bool) obj1.__lt__(obj2)).value;
    }

    @Test
    public void test_lt() {
        Date testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Date testDate2 = new Date(new Object[] {Int.getInt(2), Int.getInt(2), Int.getInt(2)}, null_kwargs);
        Assert.assertTrue(helpLt(testDate1, testDate2));
        Assert.assertFalse(helpLt(testDate2, testDate1));

        //Same Date yields fasle
        Assert.assertFalse(helpLt(testDate1, testDate1));

        //Bigger year value yields true
        testDate1 = new Date(new Object[] {Int.getInt(3), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(2)}, null_kwargs);
        Assert.assertTrue(helpLt(testDate1, testDate2));
        Assert.assertFalse(helpLt(testDate2, testDate1));

        //Bigger month value yields true
        testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(1)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertTrue(helpLt(testDate1, testDate2));
        Assert.assertFalse(helpLt(testDate2, testDate1));

        //Bigger day value yields true
        testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(2)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertTrue(helpLt(testDate1, testDate2));
        Assert.assertFalse(helpLt(testDate2, testDate1));

        Assert.assertTrue(helpLt(Date.__max__(), Date.__min__()));
        Assert.assertFalse(helpLt(Date.__min__(), Date.__min__()));


    }


    public java.lang.Boolean helpLeq(org.python.Object obj1, org.python.Object obj2) {
        return ((Bool) obj1.__le__(obj2)).value;
    }

    @Test
    public void test_le() {
        Date testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Date testDate2 = new Date(new Object[] {Int.getInt(2), Int.getInt(2), Int.getInt(2)}, null_kwargs);
        Assert.assertTrue(helpLeq(testDate1, testDate2));
        Assert.assertFalse(helpLeq(testDate2, testDate1));

        //Same Date yields True
        Assert.assertFalse(helpLeq(testDate1, testDate1));

        //Bigger year value yields true
        testDate1 = new Date(new Object[] {Int.getInt(3), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(2)}, null_kwargs);
        Assert.assertTrue(helpLeq(testDate1, testDate2));
        Assert.assertFalse(helpLeq(testDate2, testDate1));

        //Bigger month value yields true
        testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(1)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertTrue(helpLeq(testDate1, testDate2));
        Assert.assertFalse(helpLeq(testDate2, testDate1));

        //Bigger day value yields true
        testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(2)}, null_kwargs);
        testDate2 = new Date(new Object[] {Int.getInt(1), Int.getInt(1), Int.getInt(1)}, null_kwargs);
        Assert.assertTrue(helpLeq(testDate1, testDate2));
        Assert.assertFalse(helpLeq(testDate2, testDate1));

        Assert.assertTrue(helpLeq(Date.__max__(), Date.__min__()));
        Assert.assertFalse(helpLeq(Date.__min__(), Date.__min__()));
    }
}
