package zhengze;

import java.util.regex.Pattern;

public class Test {
	public static void main(String args[]){
		System.out.println("d");
		Pattern pattern = Pattern.compile("[0-9]*");   
		System.out.println(pattern.matcher("23da4").matches()); 
		String s = "^[\\s]{0,}$";
		System.out.println(Pattern.compile("^/$").matcher("/a").matches()); 
		System.out.println(Pattern.compile("\\.(html|htm|gif|jpg|jpeg|bmp|png|ico|txt|js|css|mp3|mp4)$").matcher("bc.a.html").matches()); 
		System.out.println(Pattern.compile(".*\\.(html|htm|gif|jpg|jpeg|bmp|png|ico|txt|js|css|mp3|mp4)$").matcher("bc/a.html").matches()); 
		System.out.println(Pattern.compile("/mg/").matcher("/mg/dsfad").matches()); 
	}
}
