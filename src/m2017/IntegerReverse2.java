package m2017;

/**
 * Created by bao on 2017/10/22.
 * 翻转数字
 */
public class IntegerReverse2 {

    public static void main(String args[]) {
//      int b = reverse(1235670909);
        int b = reverse(-2147483648);
        System.out.println("b=" + b);
        int a = 964632435;
        int a2 = a * 10;
        System.out.println("a =" + a);
        System.out.println("a2=" + a2);
        System.out.println("Math.abs(x)" +Math.abs(-123));
        System.out.println("Math.abs(x)" +Math.abs(-2147483648));
        System.out.println(0-(-2147483648));
    }

    public static int reverse(int x) {
        if(x<=Integer.MIN_VALUE){//因为这个数-2147483648的绝对值还是其本身
            return 0;
        }
        if (x > 0) {
            return reversePositive(x);
        }
        return reversePositive(Math.abs(x));
    }

    public static int reversePositive(int x) {
        System.out.println("x=" + x);
        long rst = 0;
        for (; ; ) {
            if (x == 0) {
                return (int) rst;
            }
            int n = x % 10;
            x = x / 10;
            long tmp = rst;
            rst = rst * 10 + n;
            System.out.println(rst);
            if (rst > Integer.MAX_VALUE) {
                return 0;
            }
        }

    }

    /***
     * 人家的代码
     */
    public int reversegood(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if (result != (newResult - tail) / 10)
                return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
