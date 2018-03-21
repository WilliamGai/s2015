package proxy.jdk;

import proxy.jdk.ProxyFactory;
import proxy.jdk.Student;
import proxy.jdk.StudentInterface;

public class Test {

	public static void main(String[] args) {
		Student student= new Student();
		ProxyFactory pf = new ProxyFactory();
		StudentInterface st = pf.createProxy(student);
		st.sayHello("william");
		
	}

}
