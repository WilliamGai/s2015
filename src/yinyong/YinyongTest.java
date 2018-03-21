package yinyong;

import java.util.*;

/**
 * Created by bao on 2017/10/23.
 */
public class YinyongTest {
    public static void main(String args[]){
//        LinkedList list = null;
//        Collections.reverse(list);


        System.out.println("heihei");
        new YinyongTest().test();
    }
    public void test(){
        Map<Object,Object> map=null;
        test(map);
        System.out.println(map);

    }
    public void test(Map<Object,Object> map){
//        map.put("a","b");
        map = new HashMap<>();
        map.put("b","c");
    }
}
