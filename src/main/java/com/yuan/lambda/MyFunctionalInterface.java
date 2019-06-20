package com.yuan.lambda;

/**
 * Lambda对函数式接口的引用
 * lambda表达式的前提，就是要使用函数式接口使用
 * 格式：(抽象方法的参数)->{抽放方法的方法体};
 * !!若抽象方法参数仅有一个时可以省略括号()
 * !!若抽象方法的方法体只有一条时，可以省略大括号{}和return;
 */
public class MyFunctionalInterface {

    @FunctionalInterface
    interface Test {
        void say(String string);
    }

    public static void main(String[] args) {
        Test t1 = new Test() {
            @Override
            public void say(String string) {
                System.out.println("传统方式创建接口方法的实现:" + string);
            }
        };

        Test t2 = (myStr) -> {
            System.out.println("lambda创建实现类对象:" + myStr);
        };
        //因为Test中的抽象方法只有1个参数，方法体内页只写了一条语句所以可以省略掉()和{}，写成：
        Test t3 = myStr -> System.out.println("lambda创建实现类对象（简写）:" + myStr);
        t1.say("t1");
        t2.say("t2");
        t3.say("t3");
    }

}
