package java8_mytest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import a_serial.data.Person;

public class EmptyList {
	public static void main(String args[]){
		System.out.println("ha");
		List<Person> list = new ArrayList<>();
		list.add(new Person("a", 1));
		list = list.stream().filter(x->x.getName().equals("b")).collect(Collectors.toList());
		System.out.println(list);
	}
}
