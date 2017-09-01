package java8_2;

import java.util.Objects;

/**
 * 函数式接口
 * 
 * @author BAO
 *
 * @param <T>
 */
@FunctionalInterface
public interface TestFunctionInterface<T> {
	boolean test(T t);

	default TestFunctionInterface<T> and(TestFunctionInterface<? super T> other) {
		Objects.requireNonNull(other);
		return (t) -> test(t) && other.test(t);
	}

	default TestFunctionInterface<T> negate() {
		return (t) -> !test(t);
	}

	default TestFunctionInterface<T> or(TestFunctionInterface<? super T> other) {
		Objects.requireNonNull(other);
		return (t) -> test(t) || other.test(t);
	}

	static <T> TestFunctionInterface<T> isEqual(Object targetRef) {
		return (null == targetRef) ? Objects::isNull : object -> targetRef
				.equals(object);
	}
}
