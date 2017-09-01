package jvm;

import java.util.ArrayList;

public class TestFinalize {

	public static void main(String[] args) throws InterruptedException {
		new ArrayList<String>(100000000){
			private static final long serialVersionUID = 1L;

			@Override
			protected void finalize() throws Throwable {
				System.out.println("finalize");
				super.finalize();
			}
		};
		Thread.sleep(100000);

	}

}
