package com.yuan.lambda.imooc.functionInterface.impl;

import com.yuan.lambda.imooc.functionInterface.IUserService;

public class IUserServiceImpl implements IUserService {

    @Override
    public String verifyUser(String username) {
        if ("admin".equals(username)) {
            return "系统管理员";
        } else if ("manager".equals(username)) {
            return "用户管理员";
        }
        return "普通会员";
    }

}
