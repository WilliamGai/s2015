package listMapSet;

import java.util.HashMap;
import java.util.Map;

import a_serial.data.Person;
/**
 * ¿½±´²»¿É¿¿
 * @author BAO
 *
 */
public class MapCopy {

	public static void main(String[] args) {
		Map<String, Person> map = new HashMap<>();
		map.put("1",new Person("a", 1));
		map.put("2",new Person("b", 2));
		map.put("3",new Person("c", 3));
		Map<String, Person> mapCopy = new HashMap<>();
		mapCopy.putAll(map);
		
		mapCopy.remove("1");
		mapCopy.get("2").setName("JHHHHH");
		System.out.println(map);
		System.out.println(mapCopy);
	}
}
