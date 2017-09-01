package exception;

import java.io.IOException;
import java.util.Arrays;

import clone.Person;

class Result{
	String result;
	Object detail;
	@Override
	public String toString() {
		return "Result [result=" + result + ", detail=" + detail.toString() + "]";
	}
	
} 
public class ExceptionTest {
	public static void main(String[] args) {
		try {
			Result r = new Result();
			System.out.println("20"+r);
		} catch (Exception e) {
//			IOException
			String s = e.toString();
			e.printStackTrace();
			System.out.println("23"+s);
		}
	}
}
