package com.yuan.lambda.sguigu.demo05;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Lambda的方法引用：Lambda表达式的另一种表现形式
 * <p>
 * 主要有三种语法：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * <p>
 * tips：（可以用这种表现形式的前提）
 * 1，Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型一致
 * 2，若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是该实例方法的参数时，可以使用类::实例方法名
 */
public class Test01 {

    public static void main(String[] args) {

    }

    //举例：对象::实例方法名
    private static void m1() {
        //Consumer这个函数式接口中的唯一抽象方法accept的参数列表是T t，无返回值
        Consumer<String> con1 = (str) -> System.out.println(str);
        //而System.out的println方法参数列表是String x，无返回值。上下一致，所以这里可以采用方法引用的方式来简写Lambda表达式
        Consumer<String> con2 = System.out::println;
    }

    //举例：类::静态方法名
    private static void m2() {
        //Comparator这个函数式接口中的唯一抽象方法compare的参数列表是T o1, T o2，返回值是int
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        //而Integer的compare方法参数列表是int x, int y，返回值是int。上下一致，所以这里可以采用方法引用的方式来简写Lambda表达式
        Comparator<Integer> com2 = Integer::compare;
    }

    //举例：类::实例方法名
    private static void m3() {
        //因为x（参数1）是实例方法的调用者，y（参数2）是这个实例方法的入参
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        //所以可以简写为 类名::实例方法名
        BiPredicate<String, String> bp2 = String::equals;
    }

}
