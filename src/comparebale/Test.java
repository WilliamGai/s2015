package comparebale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javafx.scene.effect.Lighting;

public class Test {
	public static class NameComparator implements Comparator<HashMap<String, Object>> {
		public int compare(HashMap<String, Object> hashA, HashMap<String, Object> hashB) {
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			}
			if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			}
			return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
		}
	}
	public static Comparator<HashMap<String, Object>> SizeComparator=(hashA, hashB)-> {
		int comparison = ((Boolean)hashB.get("is_dir")).compareTo((Boolean)hashA.get("is_dir"));
		if (comparison == 0) {
			comparison = ((Long)hashA.get("filesize")).compareTo((Long)hashB.get("filesize"));
		}
		return comparison;	
	};
	public static Comparator<HashMap<String, Object>> TypeComparator =(hashA, hashB)-> {
			int comparison = ((Boolean)hashB.get("is_dir")).compareTo((Boolean)hashA.get("is_dir"));
			if (comparison == 0) {
				comparison = ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
			}
			return comparison;
	};
	
	public static void main(String args[]){
		HashMap<String, Object> a = new HashMap<>();
		a.put("is_dir", true);
		a.put("filesize", 10L);
		HashMap<String, Object> b = new HashMap<>();
		b.put("is_dir", true);
		b.put("filesize", 20L);
		List<HashMap<String,Object>> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.sort(SizeComparator);
		List<Boolean> ll = Arrays.asList(true,false,true,false);
		System.out.println(list);
		ll.sort((x, y)->Boolean.compare(x, y));
		System.out.println(ll);
		
	}
}
