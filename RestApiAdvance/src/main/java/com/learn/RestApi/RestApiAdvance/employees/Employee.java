package com.learn.RestApi.RestApiAdvance.employees;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Perform all operation of Employee Class")
public class Employee {

    @ApiModelProperty(notes = "This is unique Employee id.")
    private Integer id;

    @NotNull
    @Size(min = 4, message = "name must be atleast 2 characters long")
    @ApiModelProperty(notes = "Provide Employee Name .")
    private String name;

    @Min(value=20, message="must be equal or greater than 20")
    @Max(value=65, message="must be equal or less than 65")
    @ApiModelProperty(notes = "Provide Employee Age. Must be between 20-65")
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
