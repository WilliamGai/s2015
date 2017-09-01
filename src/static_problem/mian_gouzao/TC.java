package static_problem.mian_gouzao;

import clone.Person;

public class TC extends TB{
    public TC(){
        System.out.print("TC construte");
    }
    public TC(String s){
        super();
        System.out.print("TC construte s="+s);

    }

    /***
     * 说明test(Object obj)和test(Who obj)可以共存传入null的时候变为who
     * 但是test(Who obj)和test(Who2 obj)共存的时候 这时候传入null会出错
     */
    public static void main(String args[]){
        test(null);//String

        int i=0;
        i=i++;
        System.out.println(i);//依然为0

        new TC("start");

    }
    public static void test(Object obj){
        System.out.println("obj");
    }
    public static void test(String string){
        System.out.println("string");
    }
    public static void test2(Person person){
        System.out.println("person");
    }

}
