package com.learn.RestLearning.RestBasic.employees;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeService service;

    //retrieve all users
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee=service.findEmployee(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id: "+id);
        return employee;
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee=service.saveEmployee(employee);

        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable int id)  {
        Employee employee=service.deleteEmployeeById(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id: "+id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployeeById(@Valid @RequestBody Employee employee,@PathVariable int id){
        Employee emp=service.findEmployee(id);
        if(emp==null)
            throw new EmployeeNotFoundException("Employee doesn't exist for id: "+id);

        emp.setId(emp.getId());
        emp.setAge(employee.getAge());
        emp.setName(employee.getName());

        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
