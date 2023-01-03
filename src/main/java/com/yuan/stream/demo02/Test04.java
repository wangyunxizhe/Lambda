package com.yuan.stream.demo02;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Stream的终止操作 之 查找与匹配
 */
public class Test04 {

    static List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 58, 5555.55),
            new Employee("王五", 26, 3333.33),
            new Employee("赵六", 36, 6666.66),
            new Employee("田七", 12, 8888.87),
            new Employee("田七", 12, 8888.88),
            new Employee("田七", 12, 8888.89)
    );

    public static void main(String[] args) {
        allMatch();

        anyMatch();

        noneMatch();

        findFirst();

        findAny();

        count();

        max();

        min();
    }

    //检查是否匹配所有元素
    private static void allMatch() {
        boolean b = emps.stream().allMatch((e) -> e.getName().equals("田七"));
        System.out.println(b);
    }

    //检查是否至少匹配一个元素
    private static void anyMatch() {
        boolean b = emps.stream().anyMatch((e) -> e.getName().equals("田七"));
        System.out.println(b);
    }

    //检查是否没有匹配所有元素
    private static void noneMatch() {
        boolean b = emps.stream().noneMatch((e) -> e.getName().equals("田七"));
        System.out.println(b);
    }

    //返回第一个元素
    private static void findFirst() {
        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();//得到工资最低的员工
        System.out.println(op.get());
    }

    //返回当前流中的任意元素
    private static void findAny() {
        Optional<Employee> op = emps.stream().filter((e) -> e.getName().equals("田七")).findAny();
        System.out.println(op.get());
    }

    //返回流中元素的总个数
    private static void count() {
        long count = emps.stream().count();
        System.out.println(count);
    }

    //返回流中的最大值
    private static void max() {
        Optional<Employee> op = emps.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(op.get());
    }

    //返回流中的最小值
    private static void min() {
        Optional<Double> op = emps.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(op.get());
    }

}
