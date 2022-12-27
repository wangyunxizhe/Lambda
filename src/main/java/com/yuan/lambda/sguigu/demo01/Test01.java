package com.yuan.lambda.sguigu.demo01;

import java.util.*;

/**
 * 引出Lambda的概念，比较与传统写法的区别
 */
public class Test01 {

    public static void main(String[] args) {
        beforeLambda();

        nowLambda();

        List<Employee> emps = Arrays.asList(
                new Employee("老大", 18, 9999.99),
                new Employee("老二", 38, 5555.55),
                new Employee("老三", 50, 6666.66),
                new Employee("老四", 16, 3333.33),
                new Employee("王五", 8, 7777.77)
        );
        //原始方式
        System.out.println(age35(emps));
        System.out.println(salary5000(emps));
        System.out.println(nameWang(emps));
        System.out.println("=================================================================================");
        //改进方式1：使用策略模式，方法虽然都是同一个，但遇到不同的需求，得new一个类来实现策略接口
        System.out.println(filterEmp(emps, new FilterEmpAge()));
        System.out.println(filterEmp(emps, new FilterEmpSalary()));
        System.out.println(filterEmp(emps, new FilterEmpName()));
        System.out.println("=================================================================================");
        //改进方式2：使用匿名内部类来实现策略接口
        List<Employee> list = filterEmp(emps, new MyPredicateEmployee<Employee>() {
            @Override
            public boolean predicate(Employee emp) {
                return emp.getAge() >= 35;
            }
        });
        System.out.println(list);
        System.out.println("=================================================================================");
        //改进方式3：Lambda
        System.out.println(filterEmp(emps, e -> e.getAge() >= 35));
        System.out.println(filterEmp(emps, e -> e.getSalary() >= 5000));
        System.out.println(filterEmp(emps, e -> e.getName().startsWith("王")));
    }

    //在没有Lambda之前，使用匿名内部类的写法，两个数字比大小
    private static void beforeLambda() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(5);
        ts.add(1);
        ts.add(7);
        ts.add(3);

        System.out.println(ts);
    }

    //使用Lambda实现相同的功能
    private static void nowLambda() {
        Comparator<Integer> com = (x, y) -> Integer.compare(y, x);

        TreeSet<Integer> ts = new TreeSet<>(com);
        ts.add(5);
        ts.add(1);
        ts.add(7);
        ts.add(3);

        System.out.println(ts);
    }

    /* start 改进思考 -- 以下的需求除了if语句内容不一样，其他代码皆冗余 */
    //筛选出35岁以上的员工
    private static List<Employee> age35(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //筛选出5000以上的员工
    private static List<Employee> salary5000(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //筛选姓王的员工
    private static List<Employee> nameWang(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getName().startsWith("王")) {
                emps.add(emp);
            }
        }
        return emps;
    }
    /* end 改进思考 */

    //改进方法一：使用策略模式，由N个 FilterXXX 类实现 MyPredicateEmployee 策略接口，让上述的N个方法汇总成一个方法
    private static List<Employee> filterEmp(List<Employee> list, MyPredicateEmployee<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (mp.predicate(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }


}
