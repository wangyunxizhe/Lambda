package com.yuan.lambda.sguigu.demo01;

public class FilterEmpSalary implements MyPredicateEmployee<Employee> {

    @Override
    public boolean predicate(Employee emp) {
        return emp.getSalary() >= 5000;
    }

}
