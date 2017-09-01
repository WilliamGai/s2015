package jvm;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.stream.Collectors;


public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String name = "¸Ç±£Äþ";
		Timer t = new Timer();
		TimerTask tsk = new TimerTask() {
			
			@Override
			public void run() {
				Test.printM();
			}
		};
		t.schedule(tsk,0,1000);
//		new Thread(Test::printM).start();
		Map<Object,Object> map = new HashMap<>();
		for(int i =0;i<1000;i++){
			map.put(i, i);
		}
		dosleep(5);
		t.cancel();
		System.out.println(name.getBytes("utf-8").length);
		System.out.println();
	}
	private static void printM() {
		long maxM = Runtime.getRuntime().maxMemory();
		long totalM = Runtime.getRuntime().totalMemory();
		long freeM = Runtime.getRuntime().freeMemory();
//		System.out.println("maxM=" + getM(maxM));
		System.out.println("totalM=" + getM(totalM));
		System.out.println("---- usedM=  " + getM(totalM - freeM));
	}
    public static String getM(long availmem) {
        double result = availmem / 1024f / 1024f;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(result) + " MB";
   }
 
	public static void dosleep(long seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
