package com.learn.RestApi.RestApiAdvance.employees;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {
    private static List<Employee> employee=new ArrayList<>();
    private static int employeeCount=3;

    static {
        employee.add(new Employee(1,"Komal Rawat",22));
        employee.add(new Employee(2,"Maria Rawat",10));
        employee.add(new Employee(3,"Lily Sweet",8));
    }

    public List<Employee> getAllEmployee(){
        return employee;
    }

    public Employee saveEmployee(Employee employeeDetail){
        if(employeeDetail.getId()==null)
            employeeDetail.setId(++employeeCount);
        employee.add(employeeDetail);
        return employeeDetail;
    }

    public Employee findEmployee(int id){
        for (Employee emp: employee){
            if(emp.getId()==id)
                return emp;
        }
        return null;
    }

    public Employee deleteEmployeeById(int id){
        Iterator<Employee> iterator=employee.iterator();
        while (iterator.hasNext()){
            Employee emp=iterator.next();
            if(emp.getId()==id) {
                iterator.remove();
                return emp;
            }
        }
        return null;
    }

   /* public Employee updateEmployee(Employee emp){

        employee.set(emp.getId(),emp);
        return emp;
    }
*/


}
