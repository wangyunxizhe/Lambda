package com.yuan.lambda.imooc.basic;

/**
 * lambda表达式的基本语法：
 * 1）声明：和lambda表达式绑定的接口类型
 * 2）参数：包含在一对圆括号内，和绑定接口中的抽象方法中的参数个数以及顺序要一致
 * 3）操作符：->
 * 4）执行代码块：包含在一对大括号内，在“操作符”的右侧
 * 示例：
 * [接口声明]=(参数)->{ 要执行的代码块 };
 */
public class Syntax {

    public static void main(String[] args) {
        ILambda1 il1 = () -> {
            System.out.println("无参，无返回值的lambda表达式绑定的接口");
        };
        il1.test();
        System.out.println("===========================================");
        ILambda2 il2 = (String n, int a) -> {
            System.out.println("带参，无返回值的lambda表达式绑定的接口。入参是 " + n + " : " + a);
        };
        il2.test("wy", 20);
        //简洁写法：1，如果执行代码块中只有一行代码，可以省略大括号。
        // 2，参数可以不写明类型，jvm会自动根据参数顺序去解析
        ILambda2 il2_1 = (n, a) -> System.out.println("简洁写法。入参是 " + n + " : " + a);
        il2_1.test("y.wang", 30);
        System.out.println("===========================================");
        ILambda3 il3 = (x, y) -> {
            int z = x + y;
            return z;
        };
        System.out.println("带参，带返回值的lambda表达式绑定的接口。返回值是 " + il3.test(1, 1));
        //简洁写法：如果带返回值的lambda的实现代码块中只有1行代码，可以省略“大括号”和“return”关键字。
        //默认会将这1行的执行结果作为返回值
        ILambda3 il3_1 = (x, y) -> x + y;
        System.out.println("简洁写法。返回值是 " + il3_1.test(2, 2));

        /**
         * 总结：
         * 1）Lambda表达式必须与函数式接口进行绑定。
         * 2）Lambda表达式的参数可以附带0-N个，括号中也可以不写参数的类型。JVM会自己解析
         * 3）如果带返回值的lambda的实现代码块中只有1行代码，可以省略“大括号”和“return”关键字。
         *    默认会将这1行的执行结果作为返回值；如果添加了大括号，或有多行代码，则必须通过“return”关键字返回结果。
         */
    }

    //无参，无返回值的lambda表达式绑定的接口
    interface ILambda1 {
        void test();
    }

    //带参，无返回值
    interface ILambda2 {
        void test(String name, int age);
    }

    //带参，带返回值
    interface ILambda3 {
        int test(int x, int y);
    }

}
