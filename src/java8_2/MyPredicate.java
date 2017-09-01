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
public interface MyPredicate<T> {
	boolean test(T t);

	default MyPredicate<T> and(MyPredicate<? super T> other) {
		Objects.requireNonNull(other);
		return (t) -> test(t) && other.test(t);
	}

	default MyPredicate<T> negate() {
		return (t) -> !test(t);
	}

	default MyPredicate<T> or(MyPredicate<? super T> other) {
		Objects.requireNonNull(other);
		return (t) -> test(t) || other.test(t);
	}

	static <T> MyPredicate<T> isEqual(Object targetRef) {
//		return (null == targetRef) ? Objects::isNull : object -> targetRef
//				.equals(object);
//		return Objects::isNull;
		return object -> targetRef.equals(object);
	}
}
