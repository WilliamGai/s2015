package 四舍五入;

/**
 * Created by bao on 2017/7/10.
 */
public class TestInteger {
    public static void main(String args[]){
        Integer n= 3456;
        Integer all = 100;
        int b = (int)Math.round((double)n/all);
        System.out.println(b);

    }
}
