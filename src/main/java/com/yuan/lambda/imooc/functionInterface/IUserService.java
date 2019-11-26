package com.yuan.lambda.imooc.functionInterface;

/**
 * 函数式接口要素：1，是接口。2，该接口中有且只有一个“抽象”方法。可以用注解@FunctionalInterface来检测语法
 * 用户身份认证接口
 */
@FunctionalInterface
public interface IUserService {

    /**
     * 通过用户账号，验证用户身份信息
     */
    String verifyUser(String username);

    /**
     * java8中接口可以包含非抽象的方法
     * default方法测试
     */
    default String getInfo(String username) {
        if ("admin".equals(username)) {
            return "admin + 系统管理员";
        } else if ("manager".equals(username)) {
            return "manager + 用户管理员";
        } else {
            return "commons + 普通用户";
        }
    }

}
