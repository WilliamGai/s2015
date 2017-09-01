package util;

/**InterruptedException出现的时机*/

public class ThreadTool {
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			LogCore.BASE.error("thread sleep interrupted", e);
		}
	}
}