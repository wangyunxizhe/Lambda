package com.yuan.lambda.sguigu.demo03;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lambda练习
 */
public class Test01 {

    static List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 59, 6666.66),
            new Employee("王五", 28, 3333.33),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 38, 5555.55)
    );

    public static void main(String[] args) {
        m1();

        m2();

        m3();
    }

    //练习1：将集合中的员工，先按年龄排，年龄相同按姓名排
    private static void m1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        System.out.println(emps);
    }

    //练习2：处理字符串的一些需求
    private static void m2() {
        //去除首尾空格
        System.out.println(strHandler("\t\t\t wyuan   ", (str) -> str.trim()));
        //转大写
        System.out.println(strHandler("wyuan", (str) -> str.toUpperCase()));
        //截取
        System.out.println(strHandler("abwyuancd", (str) -> str.substring(2, 7)));
    }

    private static String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    //练习3：处理两个Long型数据的运算
    private static void m3() {
        //加法
        op(100L, 200L, (x, y) -> x + y);
        //乘法
        op(100L, 200L, (x, y) -> x * y);
    }

    private static void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

}
