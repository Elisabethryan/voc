package python;
import java.lang.*;

@org.python.Module(
        __doc__ =  "This module implements functions similar to those found in the math module in python\n"
)
public class math extends org.python.types.Module {

    @org.python.Method(
        __doc__ = "Returns a the absolute value of the provided argument\n",
        args = {"x"}
    )
    public static int fabs(org.python.Object x) {
        int abs = ((org.python.types.Int) x).value;
        return (int) Math.abs(num);
    }

}
