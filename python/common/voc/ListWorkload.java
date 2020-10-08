package voc;

import org.python.types.Int;
import org.python.types.List;

public class ListWorkload {
    public static void main(String[] args) {
        List list = new List();

        for (int i = 0; i < 20000; i++) {
            list.append(Int.getInt(i));
        }

        for (int i = 0; i < 20000; i++) {
            list.insert(Int.getInt(i), Int.getInt(-i));
        }

        for (int i = 0; i < 20000; i++) {
            list.pop(Int.getInt(i % 100));
        }

        list.reverse();

        while (list.value.size() > 0) {
            list.pop(null);
        }

        System.out.println("done");
    }
}
