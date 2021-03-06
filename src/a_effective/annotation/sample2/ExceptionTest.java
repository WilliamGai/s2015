package a_effective.annotation.sample2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//149
@Retention(RetentionPolicy.RUNTIME) //在运行时保留
@Target(ElementType.METHOD)			//只在方法声明中才合法
public @interface ExceptionTest {
	Class<? extends Exception> value();
}
