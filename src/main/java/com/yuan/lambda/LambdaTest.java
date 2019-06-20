package com.yuan.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {
        String a = "a";
        System.out.println(Optional.ofNullable(a).orElse("c").contains("a"));
        //等价于
//        if (a == null) {
//            a = "c";
//        }
//        System.out.println(a.contains("a"));

        //假设构造函数没有参数 它适合Supplier签名
        Supplier<MyTestOne> s = MyTestOne::new;//构造函数引用指向默认的MyTestOne构造函数
        s.get();//调用get方法将产生一个新的MyTestOne
        s.get().say();
        //等价于
        Supplier<MyTestOne> s2 = () -> new MyTestOne();

        //如果构造函数是MyTestOne(String name), 也就是构造函数只有一个参数, 那么他就适合Function接口的签名
        Function<String, MyTestOne> f = MyTestOne::new; //指向MyTestOne(String name)的构造函数引用
        MyTestOne t1f = f.apply("一个参数的构造函数，使用“::”方式");
        t1f.say();
        //等价于
        Function<String, MyTestOne> f2 = (myStr) -> new MyTestOne(myStr);
        MyTestOne t2f = f2.apply("一个参数的构造函数，使用“->”方式");
        t2f.say();
        //简单应用例子
        List<String> sList = Arrays.asList("东", "南", "西", "北");
        List<MyTestOne> TList = getTList(sList, MyTestOne::new);
        System.out.println("共有创建了 " + TList.size() + " 个实例");

        //如果构造函数是MyTestOne(String name, Integer num), 也就是构造函数有两个参数，那么就适合BiFunction接口的签名
        BiFunction<String, Integer, MyTestOne> b1 = MyTestOne::new;
        b1.apply("八方旅人", 405);
        //等价于
        BiFunction<String, Integer, MyTestOne> b2 = (myStr, myInt) -> new MyTestOne(myStr, myInt);
        b2.apply("八方旅人", 405);
    }

    public static List<MyTestOne> getTList(List<String> sList, Function<String, MyTestOne> function) {
        List<MyTestOne> TList = new ArrayList<>();
        for (String s : sList) {
            MyTestOne t = function.apply(s);
            TList.add(t);
        }
        return TList;
    }

}
