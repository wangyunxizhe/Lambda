package com.yuan.lambda.imooc.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * lambda表达式类型检查
 * 示例总结：要注意入参的顺序和类型。
 * 1，lambda表达式类型检查的解析流程：(x,y)->{...}  --> test(param) -->
 * param=MyInterface --> 该lambda表达式 --> MyInterface类型
 * 这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型。
 * 2，lambda表达式参数类型检查的解析流程：(x,y)->{...}  --> MyInterface.ifaceTest(T t,R r) -->
 * MyInterface<String, List> iface --> T=String R=List --> (x,y)=ifaceTest(T t, R r) --> x=T=String y=R=List
 */
public class CheckType {

    public static void test(MyInterface<String, List> iface) {
        List<String> list = iface.ifaceTest("wy", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test((x, y) -> {
            y.add(x);
            return y;
        });
    }

}

/**
 * 定义一个接口：接收参数T，返回参数R
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
interface MyInterface<T, R> {

    R ifaceTest(T t, R r);

}