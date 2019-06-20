package com.yuan.lambda.StreamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream语法
 * 1.Stream是元素的集合，这点让Stream看起来用些类似Iterator；
 * 2.可以支持顺序和并行的对原Stream进行汇聚的操作；
 */
public class LambdaStream {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList(new String[]{"BB", "CC", "AA"});
        List<String> lowerList = new ArrayList<>();
        for (String s : myList) {
            lowerList.add(s.toLowerCase());
        }
        //等价于：使用Lambda表达式的写法
        List<String> lambdaL = myList.stream().map(myStr -> myStr.toLowerCase()).collect(Collectors.toList());
        System.out.println(lambdaL);

        //Lambda关于变量作用域的适用范围
        String out = "在Lambda表达式“外”部的变量";
        List<String> myList1 = Arrays.asList(new String[]{"AA", "BB", "CC"});
        List<String> lambdaL1 = myList1.stream().map(myStr -> {
            String inside = "在Lambda表达式“内”部的变量";
            return "外部变量：" + out + " 集合元素：" + myStr + " 内部变量：" + inside;
        }).collect(Collectors.toList());
        lambdaL1.forEach(System.out::println);
        //注意事项：lambda表达式访问外部变量有一个非常重要的限制：变量不可变（只是引用不可变，而不是真正的不可变）
        //编译器会隐式的把out当成final来处理，所以在lambda使用out之后，out不能再赋值

        //使用Stream的基本步骤：
        //1，创建Stream。（该例中 .stream()：创建一个Stream的实例）
        //2，转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象，可以有多次转换。
        // （该例中 .filter(num -> num != null)：把一个Stream转换成另外一个Stream，
        // .stream()语句生成的是一个包含所有nums变量的Stream，.filter(num -> num != null)以后，
        // 重新生成了一个过滤掉原nums列表所有null以后的Stream）
        //3，对Stream进行聚合（Reduce）操作，获取想要的结果
        // （该例中 .count()获取Stream中包含的元素个数）
        List<Integer> nums = Arrays.asList(new Integer[]{1, null, 3, 4, null, 6});
        long switchIntL = nums.stream().filter(num -> num != null).count();
        System.out.println("经过stream过滤后的List长度：" + switchIntL);

        //其他实用方法
        List<Integer> nums1 = Arrays.asList(new Integer[]{1, 1, null, 3, 3, 4, null, 6, 7, 8, 9, 10, 11, 12});
        List<Integer> nums1Switch = nums1.stream()
                .filter(myNum -> myNum != null)//过滤掉为null的元素
                .distinct()//去除重复的元素
                .map(myNum -> myNum * 2)//将每个元素乘以2
                .skip(2)//跳过前两个元素
                .limit(5)//实际就是下标0-4的5个元素
                .collect(Collectors.toList());//将创建的Stream对象转换成List
        System.out.println("一系列处理后的List：" + nums1Switch);
        //tips：上个例子中虽然进行了多次转换操作，但转换操作都是lazy的，
        // 多个转换操作只会在汇聚操作（Reduce）的时候融合起来，一次循环完成。


    }

}
