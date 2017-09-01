package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SameWeek {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) throws ParseException {
		long time = System.currentTimeMillis();
		
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		int year = c.get(Calendar.YEAR);
		int weak = c.get(Calendar.WEEK_OF_YEAR);
		System.out.println(year);
		System.out.println(weak);
		
		
	}
}
