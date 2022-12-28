package com.yuan.lambda.sguigu.demo04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口（函数式接口：只有一个抽象方法的接口）
 * 1，Consumer<T>：void accept(T t); === 消费型接口
 * 2，Supplier<T>：T get(); === 供给型接口
 * 3，Function<T, R>：R apply(T t); === 函数型接口
 * 4，Predicate<T>：boolean test(T t); === 断言型接口
 */
public class Test01 {

    public static void main(String[] args) {
        m1(1000.00, (m) -> System.out.println("本次花掉了 " + m + " 元"));

        System.out.println(m2(10, () -> (int) (Math.random() * 100)));

        String r = m3("   aaa      ", (str) -> str.trim());
        System.out.println(r);
        System.out.println(m3("abcdefg", (str) -> str.substring(2, 5)));

        List<String> list = Arrays.asList("Hello", "wyuan", "Lambda", "www", "ok");
        System.out.println(m4(list, (s) -> s.length() > 3));;
    }

    //消费型接口用例
    private static void m1(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //供给型接口用例：产生指定个数的整数，并放入集合中
    private static List<Integer> m2(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int n = sup.get();
            list.add(n);
        }
        return list;
    }

    //函数型接口用例：处理字符串。Function<String, String>简单解释就是，处理String类型的值，然后返回也是String类型的值（也可以返回别的类型的值）
    private static String m3(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //断言型接口用例：将满足条件的字符串放入集合中
    private static List<String> m4(List<String> list, Predicate<String> pre) {
        List<String> strs = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                strs.add(s);
            }
        }
        return strs;
    }

}
