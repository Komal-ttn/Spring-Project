package com.learn.RestApi.RestApiAdvance.employees;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.learn.RestApi.RestApiAdvance.topic.Topic;
import com.learn.RestApi.RestApiAdvance.topic.TopicService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeService service;

    @Autowired
    private TopicService topicService;

    //retrieve all users

    @GetMapping("/employee")
    @ApiOperation(value = "Get All Employee Information")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/topics")
    @ApiOperation(value = "Get All Topics")
    public List<Topic> getAllTopic(){
        return topicService.getAllTopics();
    }

    @GetMapping("/employee/{id}")
    @ApiOperation(value = "Get All Employee Information by id",
    notes = "A link to Topc will be embedded with the details of employee with name View-all-topics")
    public EntityModel<Employee> getEmployeeById(@PathVariable int id){
        Employee employee=service.findEmployee(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id: "+id);
        EntityModel<Employee> resource = EntityModel.of(employee);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTopic());

        resource.add(linkTo.withRel("View-all-topics"));
        return resource;
    }

    @PostMapping("/employee")
    @ApiOperation(value = "Save Employee Details",
            notes = "id will be auto-generated")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee=service.saveEmployee(employee);

        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation(value = "Delete Employee by id")
    public void deleteById(@PathVariable int id)  {
        Employee employee=service.deleteEmployeeById(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id: "+id);
    }

    @PutMapping("/employee/{id}")
    @ApiOperation(value = "Update Employee by id")
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
