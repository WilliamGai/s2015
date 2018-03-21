package listMapSet.map;

import mapvalue.LinkedHashMapTest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bao on 2017/10/4.
 * Collections.unmodifiableMap(map)返回的视图不可以操作
 */
public class TestMapUnModified {
    public static void main(String args[]) {
        System.out.println("map UnModified test");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        System.out.println(map);
        Map<String,Object> unmodifiableDelegatedMap = Collections.unmodifiableMap(map);
        unmodifiableDelegatedMap.put("d","D");
        System.out.println(unmodifiableDelegatedMap);

    }
}
