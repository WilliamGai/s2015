package exception;

import java.util.Arrays;

import clone.Person;

public class ExceptionTestCatch {
	public static void main(String[] args) {
		try {
			Result r = new Result();
			System.out.println(r);
		} catch (Exception e) {
			String s = e.getMessage();
			System.out.println(s);
		}
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void test() {
		test1();
	}
	public static int test1(){
		try {return  2/0;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
}
