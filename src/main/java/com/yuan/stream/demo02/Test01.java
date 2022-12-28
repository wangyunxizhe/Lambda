package com.yuan.stream.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream：1，自身不会存储数据。2，不会改变源数据
 * <p>
 * Stream的3个操作步骤：1，创建Stream。2，中间操作。3，终止操作
 */
public class Test01 {

    public static void main(String[] args) {
        /* 创建Stream */
        //1，可以通过Collection集合系列提供的stream()创建
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //2，也可以通过Arrays的静态方法stream()创建
        String[] strArr = new String[10];
        Stream<String> stream2 = Arrays.stream(strArr);
        //3，也可以通过Stream类中的静态方法of()创建
        Stream<String> stream3 = Stream.of("aaa", "bbb", "ccc");
        //4，还可以创建一种无限流
        //从0开始，每次+2
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);

        /* 中间操作 */
        //只要前10个
        Stream<Integer> limit = stream4.limit(10);

        /* 终止操作 */
        limit.forEach(System.out::println);
    }

}
