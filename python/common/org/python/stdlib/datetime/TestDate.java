package org.python.stdlib.datetime;

import org.junit.Test;
import static org.junit.Assert.*;
import org.python.stdlib.datetime.Date;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
//import org.junit.jupiter.api.Test;
import org.python.Object;
import org.python.exceptions.SyntaxError;
import org.python.exceptions.TypeError;
import org.python.exceptions.ValueError;
import org.python.types.Int;
import org.python.types.Str;

public class TestDate {

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
    public void test_repr() {
       Date testDate1 = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(3)}, null_kwargs); 
       Assert.assertEquals(testDate1.__repr__(), new org.python.types.Str("1-2-3"));

       Date testDate2 = new Date(new Object[] {Int.getInt(10), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate2.__repr__(), new org.python.types.Str("10-10-30"));

       Date testDate3 = new Date(new Object[] {Int.getInt(100), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate3.__repr__(), new org.python.types.Str("100-10-30"));

       Date testDate4 = new Date(new Object[] {Int.getInt(1000), Int.getInt(10), Int.getInt(30)}, null_kwargs); 
       Assert.assertEquals(testDate4.__repr__(), new org.python.types.Str("1000-10-30"));

       Date testDate5 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs); 
       Assert.assertEquals(testDate5.__repr__(), new org.python.types.Str("0-0-0"));
    }

    @Test
    public void test_year() {
       Date testDate1 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Date testDate2 = new Date(new Object[] {Int.getInt(2020), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Assert.assertEquals(testDate1.__year__(), new org.python.types.Str(""));
       Assert.assertEquals(testDate2.__year__(), new org.python.types.Str("2020"));
    }

    @Test
    public void test_month() {
       Date testDate1 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Date testDate2 = new Date(new Object[] {Int.getInt(0), Int.getInt(9), Int.getInt(0)}, null_kwargs);
       Assert.assertEquals(testDate1.__month__(), new org.python.types.Str(""));
       Assert.assertEquals(testDate2.__month__(), new org.python.types.Str("2020"));
    }

    @Test
    public void test_day() {
       Date testDate1 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(0)}, null_kwargs);
       Date testDate2 = new Date(new Object[] {Int.getInt(0), Int.getInt(0), Int.getInt(25)}, null_kwargs);
       Assert.assertEquals(testDate1.__day__(), new org.python.types.Str(""));
       Assert.assertEquals(testDate2.__day__(), new org.python.types.Str("25"));
    }

    @Test
    public void test_max() {
        Date testDate = (Date) Date.__max__();
        Assert.assertEquals(testDate.year, Int.getInt(9999));
        Assert.assertEquals(testDate.month, Int.getInt(12));
        Assert.assertEquals(testDate.day, Int.getInt(31));
    }

    @Test
    public void test_min() {
        Date testDate = (Date) Date.__min__();
        Assert.assertEquals(testDate.year, Int.getInt(1));
        Assert.assertEquals(testDate.month, Int.getInt(1));
        Assert.assertEquals(testDate.day, Int.getInt(1));
    }


    @Test
    public void test_today() {
        Date dateTodayTest = new Date(new Object[] {Int.getInt(1), Int.getInt(2), Int.getInt(3)}, null_kwargs);
        java.time.LocalDateTime actualToday = java.time.LocalDateTime.now();

        org.python.Object yearNow = 

       // Assert.assertEquals(todayYear.toJava(), (long) actualToday.getYear());

    }

}
