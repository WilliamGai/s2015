package fanshe.method;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bao on 2017/10/10.
 */
public class ClassUtil {
    private String test(String name, Integer age){
        return null;
    }
    public static String printMethods(Class<?> clazz){
        StringBuilder sb = new StringBuilder();
        for (Method m : clazz.getDeclaredMethods()) {
            sb.append(m.getReturnType().getSimpleName());
            sb.append("  ").append(m.getName());
            sb.append("(");
            String paramString = Stream.of(m.getParameters()).map(p->p.getType().getSimpleName()+" "+p.getName()).collect(Collectors.joining(", "));
            sb.append(paramString);
            sb.append(")\n");
        }
        return sb.toString();
    }
    public static String getGenericMethodSimpleString(Class<?> clazz) {
        List<String> list = getGenericMethodSimpleList(clazz);
        return list.stream().collect(Collectors.joining("\n")).replaceAll("([a-zA-Z]+\\.)", "");
    }
    public static List<String> getGenericMethodSimpleList(Class<?> clazz) {
        List<String> list = new ArrayList<>(clazz.getMethods().length);
        Arrays.stream(clazz.getDeclaredMethods()).forEach((m)->{
            list.add(m.toGenericString());
        });
        list.sort(Comparator.comparing(Function.identity()));
        return list;
    }
    public static void main(String args[]){
        String s = printMethods(ClassUtil.class);
        System.out.println(s);
    }
}
