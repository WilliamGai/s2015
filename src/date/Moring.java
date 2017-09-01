package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Moring {
	public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
//		c.set(Calendar.HOUR_OF_DAY,0);
		System.err.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(format.format(c.getTime()));
	}
	//容易有歧义的地方
	public static void getCalenderTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 7);
//		cal.set(Calendar.HOUR_OF_DAY, 11);
		cal.set(Calendar.HOUR, 1);
		System.err.println(format.format(cal.getTime()));
	}
	//设置月和日 8月4日
	public static void getT(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 4);
		c.set(Calendar.HOUR_OF_DAY,0);
		System.out.println(format.format(c.getTime()));
	}
}
