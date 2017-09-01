package java8_mytest.java_8_stream;

import java.util.stream.IntStream;

/**
 * Created by bao on 2017/8/29.
 */
public class TestStream {
    public static void main(String args[]){
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);//1,2
        IntStream.rangeClosed(1, 3).forEach(System.out::println);//1,2,3
    }
}
