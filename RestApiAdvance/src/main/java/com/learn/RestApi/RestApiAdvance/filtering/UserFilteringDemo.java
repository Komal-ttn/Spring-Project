package com.learn.RestApi.RestApiAdvance.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserFilteringDemo {

    @GetMapping("/filtering")
    public MappingJacksonValue userBean(){
       List<User> list=  Arrays.asList(new User("Komal Rawat", 201, "komal@123","komal@gmail.com"),
               new User("Seema Fa", 205, "seema@120","seema@gmail.com"),
               new User("Maria Sing", 202, "maria@123","maria@gmail.com"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("password","id");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);

        return mapping;

    }
}
