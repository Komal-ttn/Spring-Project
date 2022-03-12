package com.learn.jpa.JpaDemo.extraExercise;

import com.learn.jpa.JpaDemo.employee.entities.Employee;
import com.learn.jpa.JpaDemo.employee.repository.EmployeeRepository;
import com.learn.jpa.JpaDemo.extraExercise.product.entities.Product;
import com.learn.jpa.JpaDemo.extraExercise.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class extraExerciseTests {

    @Autowired
    ProductRepository repository;


    @Test
    public void testCreate(){

        Product product=new Product();
        product.setId(2);
        product.setName("Mango");
        product.setDescription("Delicious Fruit");
        product.setPrice(187.2d);
        repository.save(product);
    }

    @Test
    public void testRead(){
        Product product=repository.findById(2).get();
        assertNotNull(product);
        assertEquals("i-phone",product.getName());
    }

    @Test
    public void testUpdate(){
        Product product=repository.findById(2).get();
        product.setDescription("Updated description");
        repository.save(product);
    }

    @Test
    public void testDelete(){
        if(repository.existsById(4))
            repository.deleteById(4);
    }

    @Test
    public void testCount(){
        System.out.println("Count of rows---------->>"+repository.count());
    }

    @Test
    public  void testFindByName(){
        List<Product> products=repository.findByName("Apple");
        products.forEach(p-> System.out.println(p.getDescription()));
    }

    @Test
    public  void testFindByNameAndDesc(){
        List<Product> products=repository.findByNameAndDesc("Apple","Tomato");
        products.forEach(p-> System.out.println(p.getDescription()));
    }

    @Test
    public  void testFindByPriceGreaterThan(){
        List<Product> products=repository.findByPriceGreaterThan(100d);
        products.forEach(p-> System.out.println(p.getDescription()));
    }

    @Test
    public  void testFindByDescContains(){
        List<Product> products=repository.findByDescContains("fruit");
        products.forEach(p-> System.out.println(p.getDescription()));
    }

    @Test
    public  void testFindByPriceBetween(){
        List<Product> products=repository.findByPriceBetween(150d,300d);
        products.forEach(p-> System.out.println(p.getPrice()));
    }

    @Test
    public  void testFindByDescLike(){
        List<Product> products=repository.findByDescLike("%fruit%");
        products.forEach(p-> System.out.println(p.getDescription()));
    }

    @Test
    public  void testFindByIdsIn(){
        List<Product> products=repository.findByIdIn(Arrays.asList(1,2,3));
        products.forEach(p-> System.out.println(p.getName()));
    }
    //Pagination

    @Test
    public  void testFindAllPaging(){
        Pageable pageable=PageRequest.of(1,1);
        Page<Product> results=repository.findAll(pageable);
        results.forEach(p-> System.out.println(p.getName()));
    }

    @Test
    public  void testFindAllSorting(){
        repository.findAll(Sort.by(Sort.Direction.ASC,"name"))
                .forEach(p-> System.out.println(p.getName()));
    }

    @Test
    public  void testFindMultipleSorting(){
        repository.findAll(Sort.by(Sort.Direction.ASC,"name","price"))   //direction,properties
                .forEach(p-> System.out.println(p.getName()+"---"+p.getPrice()));

    }

    @Test
    public  void testFindMultipleSortingDifferentDirection(){
        repository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC,"name"),new Sort.Order(Sort.Direction.DESC,"price")))
                .forEach(p-> System.out.println(p.getName()+"---"+p.getPrice()));

    }

    @Test
    public void testFindAllPagingAndSorting(){
        Pageable pageable=PageRequest.of(0,1, Sort.Direction.DESC,"name");

        repository.findAll(pageable)
                .forEach(p-> System.out.println(p.getName()));
    }

    @Test
    public  void testFindByIdsInPageable(){
        Pageable pageable=PageRequest.of(1,1);
        List<Product> products=repository.findByIdIn(Arrays.asList(1,2,3),pageable);
        products.forEach(p-> System.out.println(p.getName()));
    }


}

