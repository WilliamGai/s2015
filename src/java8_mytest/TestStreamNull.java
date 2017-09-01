package java8_mytest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.Util;

public class TestStreamNull {
	/** 全部不为empty时返回真*/
	public static boolean nonEmpty(String... ss) {
		if (null == ss || 0 == ss.length)
			return false;
		return Stream.of(ss).map(Util::isEmpty).reduce((x,y)-> x || y).get();
	}
	public static void main(String[] args) {
		String[] ss = {"a","b"};
		System.out.println(nonEmpty(ss));
	}

}
