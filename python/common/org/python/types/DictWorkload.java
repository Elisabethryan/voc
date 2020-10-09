package org.python.types;
import org.python.types.Dict;
import org.python.types.Int;
import java.util.*;
import java.util.ArrayList;
import java.util.Map;

public class DictWorkload {
    public static void main(String[] args) {
        Map<org.python.Object, org.python.Object> mapping = new HashMap<>();
        Dict dict = new Dict(mapping);

        for(int i = 0; i < 100000; i++) {
            dict.__setitem__(Int.getInt(i), Int.getInt(i));
        }
        
        for(int i = 0; i < 100000; i++) {
            dict.pop(Int.getInt(i), Int.getInt(i));
        }

    }
    
}
