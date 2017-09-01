package util;

import java.util.Map;

import com.google.common.collect.Maps;

public class Test {

	public static void main(String[] args) {
		String s = "0=24219, 1=669, 2=298, 3=243, 4=182, 5=142, 6=113, 7=110, 8=82, 9=66, 10=71, 11=58, 12=47, 13=27, 14=28, 15=23, 16=28, 17=19, 18=22, 19=22, 20=20, 21=24, 22=20, 23=15, 24=12, 25=8, 26=11, 27=7, 28=9, 29=9, 30=10, 31=10, 32=7, 33=6, 34=6, 35=7, 36=1, 37=10, 38=9, 39=12, 40=855";
		 Map<String,Integer> map = parseStringIntMap(s);
		 int sum[]=new int[1];
		 map.forEach((k,v)->{
			 sum[0]+= Integer.parseInt(k)* v;
		 });
		 System.out.println(sum[0]);
	}
	public static Map<String,Integer> parseStringIntMap(String s){
		Map<String,Integer> value = Maps.newTreeMap();
		if(s==null){
			return value ;
		}
		String[] arr = s.split(",");
		for(String str : arr){
			String[] kv = str.split("=");
			Integer v = Integer.parseInt(kv[1].trim());
			value.put(kv[0].trim(), v);
			 System.out.println(kv[0].trim()+"\t"+ v);
		}
		return value ;
	}
}
