package python;

@org.python.Module(
        __doc__ = "\math?\n"
)
public class math extends org.python.math.Module {
    static {

    }

    private static long variable;

    // @org.python.Attribute
    // public static org.python.Object BuiltinFunctionType;

    // @org.python.Attribute
    // public static org.python.Object BuiltinMethodType;
    @org.python.Attribute
    public static org.python.Object attribute;


    @org.python.Method(
            __doc__ = ""
    )
    public static org.python.Object math_function() {
        throw new org.python.exceptions.NotImplementedError("math._math_function() has not been implemented.");
    }

}
