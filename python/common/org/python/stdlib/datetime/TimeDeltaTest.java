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
		  System.out.println(result);
		  System.out.println(reference);
		  assertEquals(result, reference);
	};
}
