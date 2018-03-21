package m2017;

/**
 * Created by bao on 2017/10/22.
 * 翻转数字
 */
public class IntegerReverse {

    public static void main(String args[]){
        int b = reverse(1235670909);
        System.out.print(b);
    }

    public static int reverse(int x) {
        if(x>0){
            return getReverse(x);
        }
        return 0 - getReverse(0-x);
    }

    private static int getReverse(int x) {
        try {
            String s = x+"";
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            Integer y =  Integer.parseInt(sb.toString());
            return y;
        }catch (Exception e){
            return 0;
        }

    }
}
