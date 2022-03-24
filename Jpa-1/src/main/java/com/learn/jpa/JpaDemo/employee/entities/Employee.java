package com.learn.jpa.JpaDemo.employee.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Employee {

/*    //@TableGenerator(name = "emp_gen", table = "id_gen", pkColumnName = "gen_name",valueColumnName = "gen_val",allocationSize = 100)
    @GenericGenerator(name = "emp_id",strategy = "com.learn.jpa.JpaDemo.customIdGenerator.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")*/

    //@GeneratedValue(strategy = GenerationType.TABLE,generator="emp_gen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private int age;

    @Column(name = "address")
    private String location;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
