package java8;

/**
 * 编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错
 * (删掉也没事，估计是编译时有用)
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
    boolean equals(Object obj);
    String toString();
}
