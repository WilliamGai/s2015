package sort;

// 冒泡排序
public class S1_BubbleSort {
	// 从小到大
	public static void sort(Comparable[] data) {
		// 数组长度
		int len = data.length;
		for (int i = 0; i < len - 1; i++) {
			Comparable temp = null;// 临时变量
			for (int j = len - 1; j > i; j--) {
				// 如果data[j]小于data[j-1],交换
				if (data[j].compareTo(data[j - 1]) < 0) {
					temp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = temp;
					// 发生了交换，故将交换标志置为真
				}// end if
			}
		}
	}
	// 我的理解 从小到大
	public static void sort2(Comparable[] data) {
		// 数组长度
		int len = data.length;
		for (int i = 0; i < len; i++) {
			// 临时变量
			Comparable temp = null;
			// 交换标志，false 表示未交换
			for (int j = 0; j < len - i-1; j++) {
				// 如果data[j]小于data[j-1],交换
				if (data[j].compareTo(data[j + 1]) > 0) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}// end if
			}// end for
		}// end for
	}// end sort


	//降序
	public static void sort3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					swap(nums, j,i);
				}
			}
		}
	}


	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String args[]) {
		System.out.println("hello sort");
		// 在JDK1.5以上版本，                                                                                                                                                                                                                                                                                                                                      实现了Comparable接口
		int[] c = { 1, 4, 7, 2, 5, 8, 3, 6, 9 };
		sort3(c);
		for (Comparable data : c) {
			System.out.println(data);
		}
	}
}
