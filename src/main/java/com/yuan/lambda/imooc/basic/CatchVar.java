package com.yuan.lambda.imooc.basic;

/**
 * lambda表达式变量捕获
 */
public class CatchVar {

    String s1 = "全局变量";

    //1，匿名内部类型中 对于变量的访问
    public void testInnerClass() {
        String s2 = "局部变量";
        new Thread(new Runnable() {
            String s3 = "内部变量";

            @Override
            public void run() {
                System.out.println(s1);//访问全局变量，这里不能用this. 因为这里的this指向的是Runnable
                System.out.println(s2);//但不能对局部变量进行修改，默认该变量是[final]的
                System.out.println(s3);//也可以写this.s3
            }
        }).start();
    }

    //2，lambda表达式变量捕获
    public void testLambda() {
        String s2 = "局部变量lambda";

        new Thread(() -> {
            String s3 = "内部变量lambda";

            System.out.println(this.s1);//访问全局变量，这里的this指向的就是所属方法所在的类对象
            //局部变量 内部变量的访问跟testInnerClass相同
        }).start();
    }

    public static void main(String[] args) {
        CatchVar t1 = new CatchVar();
        t1.testInnerClass();
        t1.testLambda();
    }

}
