package com.yuan.lambda.imooc.collAndFuncRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * lambda对方法的引用
 * 1）静态方法的引用：类名::方法名
 * 2）实例方法的引用：先实例化对象，再 类名::方法名 引用
 */
public class FuncRef {

    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>();
        pList.add(new Person("wy", "男", 18));
        pList.add(new Person("yw", "女", 28));
        pList.add(new Person("jack", "男", 48));
        pList.add(new Person("rose", "女", 38));
        pList.add(new Person("may", "男", 58));

        //1，利用传统方式排序，第二个参数为排序规则接口的实现逻辑
//        Collections.sort(pList, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//        System.out.println(pList);

        //2，使用lambda表达式的实现方式
//        Collections.sort(pList, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(pList);

        //3，静态方法引用
        Collections.sort(pList, Person::compareByAge);
        System.out.println(pList);

        //4，实例方法的引用
        PersonUtil pu = new PersonUtil();
        Collections.sort(pList, pu::compareByName);
        System.out.println(pList);

        //5，构造方法引用，原理参考LambdaConstructorFunction类中的注解解释
        IPerson ip = Person::new;
        Person cr = ip.init("cr", "女", 22);
        System.out.println(cr);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {

    private String name;
    private String gender;
    private int age;

    public static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

}

//用于演示实例方法引用
class PersonUtil {

    //增加一个实例方法
    public int compareByName(Person p1, Person p2) {
        return p1.getName().hashCode() - p2.getName().hashCode();
    }

}

//用于演示构造方法引用
@FunctionalInterface
interface IPerson {

    //注意返回值，以及参数列表，和Person实体类的关联
    Person init(String name, String gender, int age);

}
