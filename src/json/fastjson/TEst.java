package json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Arrays;

public class TEst {
	public static class Point{
		int x;
		int y;
		public Point(){};
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}

	}
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("result", 1);
		json.put("result", 3);
		json.put("award_id", 2);
		String rt = json.toJSONString();
		
		System.out.println(json.toJSONString());
		System.out.println(json.toString());
		List<String> list = Arrays.asList("a","c","c");
		JSONArray ja =  new JSONArray();
		ja.add(new Point(1,2));
		ja.add(new Point(3,4));
		System.out.println(ja.toJSONString());
	}

}
