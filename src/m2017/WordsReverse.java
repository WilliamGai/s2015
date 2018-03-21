package m2017;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bao on 2017/10/22.
 * 翻转句子
 * ABC  DEF  ->DEF ABC
 */
public class WordsReverse {
    public static void main(String args[]){
        String words = "ABC DEF";
        String rst = java7(words);
        String rst2 = java8(words);
//        Collections.reverse(null);
        System.out.println(rst+"END");
        System.out.println(rst2+"END");
    }
    private static String java8(String words){
        List<String> list = Arrays.asList(words.split(" "));
        Collections.reverse(list);
        return list.stream().collect(Collectors.joining(" "));
    }
    private static String java7(String words) {
        String[] ss = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < ss.length; i++){
            sb.append(ss[ss.length -1 -i]).append(" ");
        }
        String rst = sb.toString();
        rst = rst.substring(0, rst.length()-1);
        return rst;
    }
}
