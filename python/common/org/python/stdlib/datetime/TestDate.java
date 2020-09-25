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

public class TestDate {

    protected void setUp() {

    }

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

        //Strings TODO: Not sure how to supply keyword string argument
        Map<String, Object> kwargs2 = new HashMap<>();
        //kwargs1.put("year", org.python.types.Str 3);

        



    }


    @Test(expected = SyntaxError.class)
    public void testSyntaxError() {

        //Too many arguments
        Map<String, Object> kwargs = new HashMap<>();




    }



}
