package com.yuan.lambda.FunctionRef;

/**
 * Lambda构造方法引用
 * 格式===类名::new
 * 注意事项：被引用的类必须存在一个构造方法与函数式接口的抽象方法参数列表一致
 */
public class LambdaConstructorFunction {

    public static void main(String[] args) {
        //实质代码:TestForCon t = (string) -> new MyCons(string);
        //实质代码:MyCons c = t.run("张三");
        TestForCon t = MyCons::new;
        MyCons c = t.say("李四");
        System.out.println(c);

        //由于函数式接口TestForCon中抽象方法，返回值是MyCons对象，且参数列表与MyCons类中的构造方法相同，
        //所以可以通过创建函数式接口的实现类对象，方法体通过调用类中的构造方法创建对象
        //如果符合构造方法引用的所有要求，则可以写成例子中t的样式
    }

}

@FunctionalInterface
interface TestForCon {
    MyCons say(String string);
}

class MyCons {
    String name;

    public MyCons(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyCons{" +
                "name='" + name + '\'' +
                '}';
    }
}

