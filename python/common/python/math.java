package python;

@org.python.Module(
        __doc__ ="\n"
)
public class math extends org.python.types.Module {
    public math() {
        super();
    }

    @org.python.Method(
            __doc__ = "Returns a new subclass of tuple with named fields.\n" +
                "\n",
            args = {"number"}
    )
    public static int floor(org.python.Object number) {
      double num = ((org.python.types.Float) number).value;
          return (int) Math.floor(num);
    }
}
