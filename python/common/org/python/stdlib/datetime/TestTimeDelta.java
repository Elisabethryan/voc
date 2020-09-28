package org.python.stdlib.datetime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
//import junit.framework.TestCase;

public class TestTimeDelta {
  @Test
  public void test_total_seconds() {
    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
    org.python.Object[] args = {arg1};
    TimeDelta td = new TimeDelta(args, Collections.EMPTY_MAP);
    org.python.types.Str result = td.total_seconds();
    org.python.types.Str reference = new org.python.types.Str("259200");
    assert(result == reference);
  }

  @Test
  public void test_max() {
    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
    org.python.Object[] args = {arg1};
    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
    org.python.types.Str result = (org.python.types.Str) td_result.__max__();
    org.python.types.Str reference = new org.python.types.Str("999999999 days, 23:59:59:999999");
    assert(result == reference);
  }

  @Test
  public void test_min() {
    org.python.types.Int arg1 = org.python.types.Int.getInt(3);
    org.python.Object[] args = {arg1};
    TimeDelta td_result = new TimeDelta(args, Collections.EMPTY_MAP);
    org.python.types.Str result = (org.python.types.Str) td_result.__max__();
    org.python.types.Str reference = new org.python.types.Str("-999999999 days, 0:00:00");
    assert(result == reference);
  }

}
