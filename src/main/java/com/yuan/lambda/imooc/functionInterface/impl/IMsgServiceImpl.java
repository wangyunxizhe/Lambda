package com.yuan.lambda.imooc.functionInterface.impl;

import com.yuan.lambda.imooc.functionInterface.IMsgService;

public class IMsgServiceImpl implements IMsgService{

    @Override
    public String format(String msg, String format) {
        System.out.println("模拟业务。。。不做任何操作。。。");
        return msg;
    }

}
