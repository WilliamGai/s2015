package java8_mytest;

import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
//		Optional<String> op = Optional.of(null);//err
		Optional<String> op2 = Optional.ofNullable(null);
		System.out.println(op2.isPresent());//如果里面存的null则为false反之则为true
		
		
		Optional<String> op3 = Optional.ofNullable(null);
//		System.out.println(op3.get());//如果里面存的null则报异常
		System.out.println(op3.orElse(null));//修补上一行
		
		Optional<String> op4 = Optional.empty();
//		System.out.println(op4.get());//如果里面存的null则报异常
		System.out.println(op4.orElse(null));//修补上一行
		
		System.out.println(op4.isPresent());//修补上一行
	}

}
