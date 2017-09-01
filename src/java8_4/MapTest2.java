package java8_4;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import a_serial.data.Person;

public class MapTest2 {
	public static void main(String args[]) {
		/* 分组和分片 */
		Stream<Person> stream = Stream.of(new Person("a", 1), new Person("c", 2));
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Stream<Locale> locales2 = Stream.of(Locale.getAvailableLocales());
		Stream<Locale> locales3 = Stream.of(Locale.getAvailableLocales());
		Map<String,List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getDisplayCountry));
		System.out.println(countryToLocales);
		List<Locale> swissLocales = countryToLocales.get("中国");
		System.out.println(swissLocales);
		/*分类**/
		Map<Boolean, List<Locale>> englishAndOtherLocales = locales2.collect(Collectors.partitioningBy(a->a.getLanguage().equals("en")));
		List<Locale> englishLocales = englishAndOtherLocales.get(true);
		System.out.println(englishAndOtherLocales);
		System.out.println(englishLocales);
		/*计算个数*/
		Map<String, Long> countryToLocaleCounts = locales3.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
		System.err.println(countryToLocaleCounts);

	}
}
