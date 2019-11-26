package com.yuan.lambda.imooc;

public class Demo1 {

    public static void main(String[] args) {
        //1，传统模式下，新线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread..." + Thread.currentThread().getId());
            }
        }).start();

        //2，在jdk8中使用lambda表达式创建
        new Thread(()->{
            System.out.println("lambda..." + Thread.currentThread().getId());
        });
    }

}
