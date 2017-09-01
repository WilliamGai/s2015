import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;


public class Test4 {

	/**
	 *  随机选取10个属性的前五个
	 */
	public static void main(String[] args) {
			System.out.println(Math.floor(2.56));
			JdkCompiler COMPILER = new JdkCompiler(JDKCompilerHelper.class.getClassLoader());
			System.out.println(COMPILER);
		byte[] arr =  {0,1,2,3,4,5,6,7,8,9};
		List<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		
		System.out.println(test(list,5));
	}
	public static List<Object> test(List<Object> list, int size){
		Collections.shuffle(list);
		return list.subList(0, size);
	}
}
