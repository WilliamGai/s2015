import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Objects;

import com.alibaba.fastjson.JSON;


public class Test {
    //int 11 2147483647
	//       1481031620022
	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		String s = System.currentTimeMillis()+"";
		System.out.println(s);
		
		int a = 10;
		int b = 5;
		int c = (int) Math.ceil((double)a/(double)b);
		System.out.println(c);
		//-128 127
		Integer a1 = 250;
		Integer a2 =  250;
		
		Integer b1 = 25;
		Integer b2 =  25;
		Integer b3 =null;
		int b4 = 5;
		System.out.println(a1 == a2);//false
		System.out.println(b1 == b2);//true
//		System.out.println(b3 == b4);//Null pointer exception
		String url = new URL("http", InetAddress.getLocalHost().getHostName(), 1000, "").toString();
//		String prettyStr = JSON.toJSONString(rst,SerializerFeature.PrettyFormat,SerializerFeature.WriteClassName, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		System.out.println(url);
		System.out.println(url);
		System.out.println(url);
		System.out.println(InetAddress.getLocalHost().getHostName());
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
		int[] values = { 100, 101, 103, 104, 105, 102 };
		String [] arr = new String[]{};
		String [] arr1 = {"",""};


	}
	void spin(){
		for(int i=0;i<100;i++){
			;
		}
	}
}
