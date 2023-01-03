package com.yuan.optional;

import com.yuan.lambda.sguigu.demo01.Employee;

import java.util.Optional;

/**
 * Optional容器类的常用方法
 */
public class Test01 {

    public static void main(String[] args) {
        of();

//        empty();

        ofNullable();

        isPresent();

        orElse();

        orElseGet();
    }

    //创建Optional实例
    private static void of() {
        //创建一个Optional实例
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
        System.out.println(employee);
        System.out.println("====================================================================");
    }

    //创建一个空的Optional实例
    private static void empty() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
        System.out.println("====================================================================");
    }

    //Optional.ofNullable(T value)：若T不为null，创建Optional实例。否则创建空实例
    private static void ofNullable() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());
        System.out.println("====================================================================");
    }

    //isPresent()：判断是否包含值
    private static void isPresent() {
        Optional<Employee> op = Optional.ofNullable(null);
        if (!op.isPresent()) {
            System.out.println("没值");
        }
        System.out.println("====================================================================");
    }

    //orElse(T t)：如果调用对象包含值，就返回他自己的值。如果没有值，就返回T
    private static void orElse() {
//        Optional<Employee> op = Optional.ofNullable(new Employee());
        Optional<Employee> op = Optional.ofNullable(null);

        Employee emp = op.orElse(new Employee("张三", 23, 1887.66));
        System.out.println(emp);
        System.out.println("====================================================================");
    }

    //orElseGet(Supplier s)：如果调用对象包含值，就返回他自己的值。如果没有值，就返回s获取的值
    private static void orElseGet() {
        Optional<Employee> op = Optional.ofNullable(null);

        //对比orElse，orElseGet可以应对更多业务情况，在哪些情况下返回具体哪些对象
        Employee emp = op.orElseGet(() -> {
            if (true) {
                return new Employee();
            } else if (true) {
                return new Employee("张三", 23, 1887.66);
            } else {
                return new Employee("李四", 23, 1887.66);
            }
        });
        System.out.println(emp);
        System.out.println("====================================================================");
    }

}
