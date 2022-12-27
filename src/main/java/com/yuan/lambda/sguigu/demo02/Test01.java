package com.yuan.lambda.sguigu.demo02;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 基本语法
 * -> 左侧：Lambda表达式的参数列表（就是函数式接口方法中的参数列表）
 * -> 右侧：Lambda表达式中所需执行的功能，即Lambda体（就是函数式接口方法的具体实现）
 * 函数式接口：只有一个抽象方法的接口
 */
public class Test01 {

    public static void main(String[] args) {
        //演示Lambda基本语法。Runnable就符合 函数式接口 的定义

        //语法格式一：无参无返回值
        m1();
        //语法格式二：单参无返回值
        m2();
        //语法格式三：两个及以上参数，有返回值，Lambda体中有多条语句
        m3();
    }

    //语法格式一：无参无返回值
    private static void m1() {
        //原来的方式
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("老样子");
            }
        };
        r1.run();

        System.out.println("===============================================");

        //Lambda
        Runnable r2 = () -> System.out.println("新造型");
        r2.run();
    }

    //语法格式二：单参无返回值
    private static void m2() {
        //tips：如果只有一个参数，小括号也可以不写
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Lambda 语法二");
    }

    //语法格式三：两个及以上参数，有返回值，Lambda体中有多条语句
    private static void m3() {
        //tips：如果Lambda体中只有一条语句，那么大括号和return都可以省略
        Comparator<Integer> com = (x, y) -> {
            System.out.println("两个以上入参，有返回值");
            return x + y;
        };
        System.out.println("返回值：" + com.compare(1, 2));
    }

}
