package com.yuan.lambda.sguigu.demo01;

public class FilterEmpName implements MyPredicateEmployee<Employee> {

    @Override
    public boolean predicate(Employee emp) {
        return emp.getName().startsWith("王");
    }

}
