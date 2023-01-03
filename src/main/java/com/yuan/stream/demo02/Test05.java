package com.yuan.stream.demo02;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream的终止操作 之 归约与收集
 */
public class Test05 {

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
        reduce0();

        reduce1();

        collect0();
    }

    //规约的基础操作
    private static void reduce0() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //reduce === 给一个起始值（0），第一次计算时x为0，y为list中的第一个元素1，根据x+y故计算结果为1。
        //第二次计算时x为1，y为list中的第二个元素2，计算结果为3。。。依此类推，直至加到10为止
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    //计算工资总和
    private static void reduce1() {
        Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());
    }

    //收集的基础操作
    private static void collect0(){
        List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(list);

        Set<Integer> set = emps.stream().map(Employee::getAge).collect(Collectors.toSet());
        System.out.println(set);

        HashSet<String> hSet = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(hSet);
    }

}
