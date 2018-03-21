package yinyong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bao on 2017/10/23.
 */
public class YinyongTest2 {
    public static void main(String args[]){


        System.out.println("heihei");
        new YinyongTest2().test();
    }
    public void test(){
        Map<Object,Object> map= new HashMap<>();
        map.put("a","A");
        test(map);
        System.out.println(map);

    }
    public void test(Map<Object,Object> map){
//        map.put("a","b");
        map = new HashMap<>();
        map.put("b","c");
    }
}
