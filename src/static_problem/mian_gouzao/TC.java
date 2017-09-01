package static_problem.mian_gouzao;

public class TC extends TB{
    public TC(){
        System.out.print("TC construte");
    }
    public TC(String s){
        super();
        System.out.print("TC construte s="+s);

    }
    public static void main(String args[]){
        test(null);//String

        int i=0;
        i=i++;
        System.out.println(i);//依然为0，

        new TC("start");

    }
    public static void test(Object obj){
        System.out.println("obj");
    }
    public static void test(String string){
        System.out.println("string");
    }
}
