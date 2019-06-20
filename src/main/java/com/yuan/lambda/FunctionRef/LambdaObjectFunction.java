package com.yuan.lambda.FunctionRef;

/**
 * Lambda对 对象方法的引用
 * 格式===对象名::非静态方法名
 * 注意事项：与静态方法引用完全一致
 */
@FunctionalInterface
interface TestForObj {
    String say(String string);
}

class MyObj {
    public String go(String string) {
        return string.concat(" 引用方法");
    }
}

public class LambdaObjectFunction {

    public static void main(String[] args) {
        //实质代码:TestForObj t = (string) -> new MyObj().go(string);
        TestForObj t = new MyObj()::go;
        System.out.println(t.say("对象"));

        //MyObj类中有一个方法go()方法体是TestForObj实现类对象需要的方法体，且方法列表参数一致，返回值类型相同
        //所以可以利用lambda创建TestForObj的实现类对象，然后重写的抽象方法体就是调用MyObj对象的go方法
        //如果符合对象引用方法的所有要求，则可以写成例子中t的样式
    }

}
