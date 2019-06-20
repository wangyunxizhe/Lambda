package com.yuan.lambda;

public class MyTestOne {

    private String name;
    private Integer num;

    public MyTestOne() {
    }

    public MyTestOne(String name) {
        this.name = name;
    }

    public MyTestOne(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public void say() {
        System.out.println("say() name=" + name);
    }

}
