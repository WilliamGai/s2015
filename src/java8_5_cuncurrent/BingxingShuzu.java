package java8_5_cuncurrent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * 151并行数组
 * java8读取文件
 */
public class BingxingShuzu {

	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("test.txt")), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");// 根据非字母字符对字符串进行分隔
		// Arrays.parallelSort(words);
		Arrays.parallelSort(words, words.length / 2, words.length);// 只对后一半排序
		System.out.println(Arrays.toString(words));
		/*
		 * parallelSetAll会将数组中的值按照一个函数的计算结果过滤出来。该函数会获得元素索引，并计算该位置处的值
		 */
		int[] values = { 100, 101, 103, 104, 105, 102 };
		Arrays.parallelSetAll(values, i -> i % 3);// [0, 1, 2, 0, 1, 2]
		System.out.println(Arrays.toString(values));
		/*
		 *下面的计算依然可以并行完成，在log(n)步之后，处理完毕，如果有足够的处理器，它的性能要好过线性运算
		 */
		int[] values2 = { 1, 2, 3, 4, 5, 6 };
		Arrays.parallelPrefix(values2, (x, y) -> x * y);//[1, 2, 6, 24, 120, 720]
		System.out.println(Arrays.toString(values2));

	}

}
