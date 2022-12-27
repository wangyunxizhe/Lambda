package com.yuan.lambda.sguigu.demo01;

public class FilterEmpAge implements MyPredicateEmployee<Employee> {

    @Override
    public boolean predicate(Employee emp) {
        return emp.getAge() >= 35;
    }

}
