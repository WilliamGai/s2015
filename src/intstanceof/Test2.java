package intstanceof;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bao on 2017/8/6.
 */
public class Test2 {
    public static void main(String args[]){
        System.out.println(Map.class.isAssignableFrom(HashMap.class));
        System.out.println(null instanceof String);
        System.out.println(String.class.isInstance("a"));
    }
}
