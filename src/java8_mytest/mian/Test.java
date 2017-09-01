package java8_mytest.mian;

import alex.Student;
import alex.Student;

import java.util.*;

/**
 * Q:给一些学生的成绩 有男同学 有女同学，如何找出男同学中和女同学中分数最高的同学
 */
public class Test {
    private static class Student implements Comparable<Student> {
        public String name;
        public int gender;
        public int score;

        public Student(String name, int gender, int score) {
            this.name = name;
            this.gender = gender;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.score, o.score);
        }

        public static int compare(Student a, Student b) {
            return a.compareTo(b);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("name='").append(name).append('\'');
            sb.append(", gender=").append(gender);
            sb.append(", score=").append(score);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * 类似
     * Comparator.comparing(Person::getHeight)
     */
    private static Comparator<Student> comparator = Student::compare;

    public static void main(String args[]) {
        Student senan = new Student("senan", 0, 5);
        Student senan2 = new Student("senan2", 0, 7);
        Student senan3 = new Student("senan3", 0, 6);
        Student boa = new Student("boa", 1, 2);
        Student boa2 = new Student("boa2", 1, 4);
        Student boa3 = new Student("boa3", 1, 3);
        List<Student> list = new ArrayList<>(6);
        list.add(senan);
        list.add(senan2);
        list.add(senan3);
        list.add(boa);
        list.add(boa2);
        list.add(boa3);
        /**方法一拉姆达表达式 类似map reduce
         * */
        Student rst = list.stream().filter(s -> s.gender == 0).max(comparator).get();
        HashMap<Object, Student> map = new HashMap<>();
        map.computeIfAbsent(2, (k) -> new Student("senan", 0, 5));//如果没有 执行表达式，生成KV
        /**
         * 方法2 使用一个HashMap类似于map reduce
         */
        list.forEach(s-> map.merge(s.gender, s, (a, b) -> a.score > b.score ? a : b));
        System.out.println("hello" + rst);
        System.out.println("map=" + map);
    }
}
