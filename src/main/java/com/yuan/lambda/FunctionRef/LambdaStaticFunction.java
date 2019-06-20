package com.yuan.lambda.FunctionRef;

/**
 * Lambda对静态方法的引用
 * 格式===类名::方法名
 * 注意事项：
 * 引用方法的参数列表和函数式接口中抽象方法的参数必须一致！！
 * 接口的抽象方法没有返回值，引用的方法可以有返回值也可以没有，
 * 接口的抽象方法有返回值，引用的方法必须有相同类型的返回值！！
 */
public class LambdaStaticFunction {

    @FunctionalInterface
    interface TestForStatic {
        void say(String string);
    }

    @FunctionalInterface
    interface ReturnStr {
        String rStr(Integer num);
    }

    @FunctionalInterface
    interface ReturnInt {
        int rInt(String string);
    }

    public static void main(String[] args) {
        //例子1
        printString("静态方法引用", System.out::println);
        //实质代码:printString("静态方法引用", (string) -> System.out.println(string));

        //函数式接口ReturnStr中的抽象方法返回值是String，所以rStr方法的第二个参数中（引用方法）返回值也必须是String
        String s = rStr(1, myNum -> myNum + "：函数式接口返回值为String");
        System.out.println(s);

        //例子2
        //函数式接口ReturnInt中的抽象方法返回值是int，所以getInteger方法的第二个参数中（引用方法）返回值也必须是int
        String i = getInteger("123", Integer::parseInt);
        //实质代码:getInteger("123", (str) -> Integer.parseInt(str));
        System.out.println(i);

        //例子1，2中，分别调用System.out类的println静态方法，Integer类的parseInt静态方法。
        //由于满足抽象参数列表与引用参数列表相同，所以可以写成静态方法引用的格式
    }

    public static void printString(String str, TestForStatic t) {
        t.say(str);
    }


    public static String rStr(Integer num, ReturnStr r) {
        String s = "rStr方法：" + r.rStr(num);
        return s;
    }

    public static String getInteger(String str, ReturnInt r) {
        return String.valueOf(r.rInt(str));
    }
}
