package com.yuan.lambda.imooc.collAndFuncRef;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对Stream的应用
 */
public class TestStream {

    public static void main(String[] args) {
        //测试数据
        List<String> tests = new ArrayList<>();
        tests.add("1");
        tests.add("22");
        tests.add("54321");
        tests.add("12345");
        tests.add("55555");

        //业务要求：长度大于等于5的才是有效数据。使用Stream结合lambda来完成该要求
        List valids = tests.stream().filter(t -> t.length() >= 5).collect(Collectors.toList());
        System.out.println(valids);
    }

}
