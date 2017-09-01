package java8_5_cuncurrent;

import java.util.concurrent.atomic.AtomicLong;

public class Test {

	public static void main(String[] args) {
		AtomicLong largest = new AtomicLong();
		long obsvValue = 1;
		long oldValue=2;
		long newValue;
		do {
			oldValue = largest.get();//a
			newValue = Math.max(obsvValue, oldValue);
			System.out.println("largest.get() =" + largest.get() + ",newValue=" + newValue);
//			largest.accumulateAndGet();
		} while (!largest.compareAndSet(oldValue, newValue));//b,a和b缺一不可！

	}

}
