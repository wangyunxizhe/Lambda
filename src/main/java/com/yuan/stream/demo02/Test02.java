package com.yuan.stream.demo02;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stream的中间操作 之 筛选与切片
 */
public class Test02 {

    static List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 58, 5555.55),
            new Employee("王五", 26, 3333.33),
            new Employee("赵六", 36, 6666.66),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.88)
    );

    public static void main(String[] args) {
        filter();
        System.out.println("=====================================================================");
        limit();
        System.out.println("=====================================================================");
        skip();
        System.out.println("=====================================================================");
        distinct();
        System.out.println("=====================================================================");
    }

    private static void filter() {
        //创建 -> 中间操作 -> 终止操作 连写
        emps.stream().filter((e) -> {
            System.out.println("Stream的中间操作");
            return e.getAge() > 35;
        }).forEach(System.out::println);
    }

    private static void limit() {
        //创建 -> 中间操作 -> 终止操作 连写
        //取前两个
        emps.stream().filter((e) -> e.getSalary() > 5000).limit(2).forEach(System.out::println);
    }

    private static void skip() {
        //创建 -> 中间操作 -> 终止操作 连写
        //跳过前两个
        emps.stream().filter((e) -> e.getSalary() > 5000).skip(2).forEach(System.out::println);
    }

    private static void distinct() {
        //创建 -> 中间操作 -> 终止操作 连写
        //去重
        emps.stream().distinct().forEach(System.out::println);
    }

}
