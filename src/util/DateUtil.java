package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateUtil{
	INSTANCE;
	
	private static String format = "";
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:SSS");
	public String getTodayStamp(){
		return sdf.format(new Date());
	}
	public static void main(String args[]){
		System.out.println(DateUtil.INSTANCE.getTodayStamp());
	}
} 