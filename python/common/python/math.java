package python;


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
    public static double fabs(org.python.Object x) {
        double abs = ((org.python.types.Float) x).value;
        return Math.abs(abs);
    }

}
