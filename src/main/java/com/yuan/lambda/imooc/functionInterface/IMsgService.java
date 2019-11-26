package com.yuan.lambda.imooc.functionInterface;

/**
 * 消息传输格式转换接口
 */
@FunctionalInterface
public interface IMsgService {

    /**
     * 消息转换方法
     *
     * @param msg    要转换的消息
     * @param format 转换的格式【xml/json。。。】
     * @return
     */
    String format(String msg, String format);

    /**
     * java8中接口可以包含非抽象的方法
     * 静态方法测试
     */
    static boolean verifyMsg(String msg) {
        if (msg != null) {
            return true;
        }
        return false;
    }

}
