package fanshe.method;

import java.lang.reflect.Method;

import fanshe.ReflectPoint;
/**
 * 调用某个对象的私有方法
 */
public class TestMethod2 {
	
	public static void main(String args[]){
		//1
		ReflectPoint r = new ReflectPoint(1, 2);
		Object o = getReflectObject(r.getClass(),r, "getTest",new Object[]{ "你好"}, String.class);
//		System.out.println(o);
		System.out.println(o);

		
		//2
		ReflectPoint r2 = new ReflectPoint(1, 4);
		Method mtd = getMethod(ReflectPoint.class, "getTest", String.class);
		Object o2 = invokeMethod(mtd, r2, new Object[]{ "你"});
		System.out.println(o2);
	}
	/* 如果无返回值则返回null */
	public static Object invokeMethod(Method mtd, Object obj, Object... args){
		mtd.setAccessible(true);
		try {
			return mtd.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes){
		Method mtd = null;
		try {
			mtd = clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return mtd;
		}
		return mtd;
	}
	/**
	 * ()通过反射获得某个对象的某个方法，并返回方法的结果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getReflectObject(Class<?> clazz, Object r, String methodName,Object[] params, Class<?>... parameterTypes){
		try {
			Method mtd = clazz.getDeclaredMethod(methodName, parameterTypes);
			mtd.setAccessible(true);
			return (T) mtd.invoke(r, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
