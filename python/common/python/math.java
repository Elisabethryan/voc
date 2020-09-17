package python;

import java.lang.*;

@org.python.Module(
        __doc__ = "\nMath module\n"
)
public class math extends org.python.types.Module {
    public math(){
        super();
    }


    @org.python.Method(
        __doc__ = "Implements the Math.ceil function",
        args = {"number"}
    )
    public static int ceil(org.python.Object number) {
        double num = ((org.python.types.Float) number.__float__()).value;
        return (int)Math.ceil(num);
    }

}
