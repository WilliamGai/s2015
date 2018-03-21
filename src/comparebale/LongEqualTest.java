package comparebale;
/***
 * 切记:
 * 如果a是long 类型 a instanceof Long根本编译不过
 * 但是如果long 类型由Object 传过来 则 long 类型会自动包装为Long 类型
 * @author bao
 *
 */
public class LongEqualTest {

	public static void main(String[] args) {
		 long a = 1L;
		 Long b = 1L;
		 long.class.isInstance(a);//传long和Long都为false
		 Long.class.isInstance(a);//传long和Long都为true
//       System.out.println(a instanceof Long);//编译错误
		 System.out.println(long.class.isInstance(b));//传long和Long都为false
		 System.out.println(Long.class.isInstance(b));//传long和Long都为true
        System.out.println(b.equals(a));

	}

}
