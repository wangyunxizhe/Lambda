package com.yuan.stream.demo02;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * Stream的中间操作 之 映射与排序
 */
public class Test03 {

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
        map();

        sort();
    }

    private static void map() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        //将元素都转为大写
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
        //源数据并未改变
        System.out.println(list);
        System.out.println("=====================================================================");
        //提取的对象中的“name”属性
        emps.stream().map((e) -> e.getName()).forEach(System.out::println);
        System.out.println("=====================================================================");
    }

    private static void sort() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("=====================================================================");
        emps.stream().sorted((e1, e2) -> {
            if (e1.getAge() > e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge();
            }
        }).forEach(System.out::println);
        System.out.println("=====================================================================");
    }

}
