package com.learn.jpa.JpaDemo.employee.repository;

import com.learn.jpa.JpaDemo.employee.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    //find Employee by Name
    List<Employee> findByName(String name);

    //find Employees starting with A character.
    List<Employee> findByNameLike(String name);

    //find Employees Between the age of 28 to 32
    List<Employee> findByAgeBetween(int age1,int age2);

}
