package com.yuan.lambda.imooc.collAndFuncRef;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream常见操作API介绍：
 * 一，聚合操作
 * <p>
 * 二，获取Stream对象
 * 1）从集合中获取 集合类.stream
 * 2）从数组中获取 Arrays.stream(数组)
 * <p>
 * 三，中间操作API
 * 1）中间操作：
 * 就可以理解为是对Stream中的业务逻辑处理。可只有1个也可连写多个。
 * 中间操作只记录操作方式，不做具体执行。直到结束操作发生时，才做数据落地。
 * 2）中间操作过程：
 * 无状态 --> 处理业务时，不受前置中间操作的影响。具体有
 * map/filter/peek/parallel/sequential/unordered
 * 有状态 --> 处理业务时，受到前置中间操作的影响。具体有
 * distinct/sorted/limit/skip
 * <p>
 * 四，结束操作
 * 注意：一个Stream只能有一个结束操作，一旦发生就会真实的处理数据，且不可逆。
 * 1）非短路操作：
 * 当前的Stream必须处理完集合中所有的数据，才能得到处理结果。具体有
 * forEach/forEachOrdered/toArray/reduce/collect/min/max/count/iterator
 * 2）短路操作：
 * 当前的Stream在处理过程中，一旦满足某个条件，就可以得到结果。具体有
 * anyMatch/allMatch/noneMatch/findFirst/findAny
 */
public class StreamAPI {

    public static void main(String[] args) {
        //1，批量数据 --> Stream对象
        //多个数据
        Stream stream1 = Stream.of("wy", "jack", "rose");
        //数组
        String[] strArr = new String[]{"ming", "qiang", "juan"};
        Stream stream2 = Arrays.stream(strArr);
        //集合，set用法一样
        List<String> list = new ArrayList<>();
        list.add("广州");
        list.add("上海");
        list.add("北京");
        list.add("南京");
        Stream stream3 = list.stream();
        //map
        Map<String, Integer> map = new HashMap<>();
        map.put("wy", 1000);
        map.put("jack", 1200);
        map.put("rose", 1400);
        Stream stream4 = map.entrySet().stream();

        //2，Stream对于基本数据类型的功能封装
        //int long double 有单独的Stream封装，以int为例
        IntStream.of(new int[]{10, 20, 30}).forEach(System.out::println);
        IntStream.range(1, 5).forEach(System.out::println);//范围操作。1-4，不包含5
        IntStream.rangeClosed(1, 5).forEach(System.out::println);//范围操作。1-5，包含5

        //3，Stream对象 --> 转换得到指定的数据类型
        //数组。指定转换成String类型的数组
        Object[] objx = stream1.toArray(String[]::new);
        //字符串。将stream中的内容都拼接到一起，合成一个字符串
        String s = stream2.collect(Collectors.joining()).toString();
        System.out.println(s);
        //集合
        Stream stream5 = Stream.of(1, 2, 3);
        List<String> l = (List<String>) stream5.collect(Collectors.toList());
        System.out.println(l);
        Stream stream6 = Stream.of("1", "2", "3");
        Set<Integer> set = (Set<Integer>) stream6.collect(Collectors.toSet());
        System.out.println(set);
        //Map。stream3是List转换来的，stream4是Map转换来的，用于测试
        Map<String, String> mapx = (Map<String, String>) stream3.collect(Collectors.toMap(x -> x, y -> "value：" + y));
        System.out.println(mapx);
        Map<String, String> mapx1 = (Map<String, String>) stream4.collect(Collectors.toMap(x -> x, y -> "value：" + y));
        System.out.println(mapx1);

        //4，Stream中常见的API操作
        List<String> ls = new ArrayList<>();
        ls.add("aa");
        ls.add("bb");
        ls.add("cc");
        ls.add("dd");
        ls.add("ee");
        //中间操作 无状态
        //map() 示例：在元素前面加字符
        ls = ls.stream().map(x -> "测试加个前缀：" + x).collect(Collectors.toList());
        //filter() 可根据业务过滤数据 示例：保留长度大于5的元素
        ls = ls.stream().filter(x -> x.length() > 5).collect(Collectors.toList());
        //peek() 迭代数据完成数据的依次处理过程 注意：示例中的forEach是终结操作
        ls.stream().peek(x -> System.out.println("peek 1:" + x))
                .peek(x -> System.out.println("peek 1:" + x))
                .forEach(System.out::println);
        ls.forEach(System.out::println);
        //中间操作 无状态
        //Stream对于数字运算的支持
        List<Integer> intList = new ArrayList<>();
        intList.add(20);
        intList.add(7);
        intList.add(19);
        intList.add(8);
        intList.add(66);
        intList.add(11);
        intList.add(3);
        intList.add(20);
        //skip() 跳过Stream中的部分数据 示例：跳过前3个元素从第4个开始
        intList.stream().skip(3).forEach(System.out::println);
        //limit() 限制数据量
        intList.stream().skip(3).limit(2).forEach(System.out::println);
        //distinct()
        intList.stream().distinct().forEach(System.out::println);
        //sorted() 排序 跟上面操作差不多，省略示例
        System.out.println("==========================================");
        //max() min() reduce()合并处理数据
        Optional omax = intList.stream().max((x, y) -> x - y);
        System.out.println(omax.get());
        Optional oreduce = intList.stream().reduce((sum, x) -> sum + x);
        System.out.println(oreduce.get());
    }

}
