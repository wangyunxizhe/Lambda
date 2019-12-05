package com.yuan.lambda.imooc.basic;

/**
 * 方法重载对于lambda表达式的影响
 */
public class Reload {

    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    //定义重载的方法
    public void lambdaMethod(Param1 p1) {
        p1.outInfo("这里是Param1的实现");
    }

    public void lambdaMethod(Param2 p2) {
        p2.outInfo("这里是Param2的实现");
    }

    public static void main(String[] args) {
        Reload reload = new Reload();
        /**
         * 下面代码编译报错的原因：
         * lambda存在类型检查 --> 自动推导出lambda表达式的目标类型 -->
         * 该方法为重载方法，推导出了Param1，Param2两个目标类型
         */
//        reload.lambdaMethod(() -> {
//
//        });
        /**
         * 总结：如果要引用的方法入参存在重载函数式接口的情况，请使用传统方式实现，lambda表达式不支持
         */
    }

}
