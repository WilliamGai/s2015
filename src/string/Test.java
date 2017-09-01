package string;

public class Test {

	public static void main(String[] args) {
		String s1="a";
		String s2=s1+"b";
		String s3="a"+"b";
		System.out.println(s2=="ab");
		System.out.println(s3=="ab");
		
		String s="";
		System.out.println(s.split(",").length);
	}
}
