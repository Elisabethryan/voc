package python;
import java.lang.*;
import org.python.types.Int;

@org.python.Module(
        __doc__ =  "This module implements functions similar to those found in the math module in python\n"
)
public class math extends org.python.types.Module {
    public math() {
        super();
    }

    @org.python.Method(
        __doc__ = "Returns a the absolute value of the provided argument\n",
        args = {"x"}
    )
    public static int abs(org.python.Object x) {
        long abs = ((org.python.types.Int) x).value;
        return (int) java.lang.Math.abs(abs);
    }

}
