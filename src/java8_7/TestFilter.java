package java8_7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestFilter {
	public static void main(String args[]){
		List<String> names = Arrays.asList("william", "with", "lishengnan");
		List l = names.stream().filter(t->true).collect(Collectors.toList());
		System.out.println(l);
	}
}
