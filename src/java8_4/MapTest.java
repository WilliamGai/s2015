package java8_4;

import huidiao.sample2.Local;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.xml.internal.txw2.output.StreamSerializer;

import a_serial.data.Person;

public class MapTest {
	public static void main(String args[]) {
		// 将结果收集到map中
//		Person p = ;
		Person p2 = new Person("b", 2);
		Stream<Person> stream = Stream.of(new Person("a", 1), new Person("c", 2));
//		Map<String,Person> pMap = stream.collect(Collectors.toMap(Person::getName, p->p));
//		System.out.println(pMap);
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//		Map<String,String> languageNames = locales.collect(Collectors.toMap(a->a.getDisplayLanguage(), b->b.getDisplayLanguage(), (existValue, newValue)->newValue));
//		System.out.println(languageNames);
		//得到一个TreeMap
		Map<String, Person> idToPerson 
		= stream.collect(Collectors.toMap(Person::getName, Function.identity(), (a,b)->{throw new NullPointerException();},TreeMap::new));
		System.out.println(idToPerson);
		
		Map<String,Set<String>> countryLanguageSets = locales.collect(
				Collectors.toMap(
						a->a.getDisplayCountry(), 
						b->Collections.singleton(b.getDisplayLanguage()),
						(c, d)->{Set<String> r = new HashSet<>();r.addAll(d);return r;}
						)
					);
		System.out.println(countryLanguageSets);


	}
}
