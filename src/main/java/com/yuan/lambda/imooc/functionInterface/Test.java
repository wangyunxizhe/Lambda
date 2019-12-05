package com.yuan.lambda.imooc.functionInterface;

import com.yuan.lambda.imooc.functionInterface.impl.IMsgServiceImpl;
import com.yuan.lambda.imooc.functionInterface.impl.IUserServiceImpl;
import java.util.function.*;

/**
 * 函数式接口测试
 */
public class Test {

    public static void main(String[] args) {
        //一，传统方式
        IUserService iu = new IUserServiceImpl();
        //使用抽象方法
        System.out.println(iu.verifyUser("admin"));
        //使用default方法
        System.out.println(iu.getInfo("manager"));
        System.out.println("========================================");
        String msg = "wang yuan";
        if (IMsgService.verifyMsg(msg)) {//可以像引用普通类中的静态方法一样，引用接口中的静态方法
            IMsgService im = new IMsgServiceImpl();
            im.format(msg, "json");
        }
        System.out.println("========================================");
        //二，使用lambda表达式，针对函数式接口的简单实现
        IUserService iuL = (String username) -> {
            return "admin".equals(username) ? "lbd管理员" : "lbd会员";
        };
        System.out.println(iuL.verifyUser("admin"));
        System.out.println("========================================");
        //三，使用jdk8中自带的函数式接口
        //Predicate 接收参数对象T，返回boolean
        Predicate<String> pre = (String test) -> {
            return "admin".equals(test);
        };
        System.out.println(pre.test("admin"));
        System.out.println(pre.test("manager"));
        //Consumer 接收参数对象T，不返回
        Consumer<String> con = (String test) -> {
            System.out.println("输入的入参是：" + test);
        };
        con.accept("wang yuan");
        //Function 接收参数对象T，返回对象R。示例中接收对象为String，返回对象为Integer
        Function<String, Integer> fun = (String sex) -> {
            return "man".equals(sex) ? 1 : 0;
        };
        System.out.println(fun.apply("man"));
        System.out.println(fun.apply("woman"));
        //Supplier 不接收参数，提供T对象的创建工厂
        Supplier<String> sup = () -> {
            return "返回定义时的类型，这里是String";
        };
        System.out.println(sup.get());
        //UnaryOperator 接收参数对象T，返回结果对象T。传什么对象处理后还返回什么对象
        UnaryOperator<String> uo = (String text) -> {
            text += "经过业务处理后。。。";
            return text;
        };
        //该函数式接口并没有自己的抽象方法，但它继承了Functiona接口，所以可以用apply方法
        System.out.println(uo.apply("原文字"));
        //BinaryOperator 接收2个T对象，返回一个T对象的结果
        BinaryOperator<Integer> bo = (Integer i1, Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };
        System.out.println(bo.apply(11, 12));
    }

}
