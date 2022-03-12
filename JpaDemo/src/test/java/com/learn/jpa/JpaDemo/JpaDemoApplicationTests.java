package com.learn.jpa.JpaDemo;

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
class JpaDemoApplicationTests {

	@Autowired
	ProductRepository repository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	//Employee

	@Test
	public void testEmpCreate() {

		Employee employee = new Employee();
		employee.setName("Saizal");
		employee.setAge(25);
		employee.setLocation("california");

		employeeRepository.save(employee);
	}

	@Test
	public void testEmpUpdate() {
		Employee employee = employeeRepository.findById(2).get();
		employee.setLocation("Noida");
		employeeRepository.save(employee);
	}

	@Test
	public void testEmpDelete() {
		if (employeeRepository.existsById(4))
			employeeRepository.deleteById(4);
	}

	@Test
	public void testEmpRead() {
		Employee employee = employeeRepository.findById(2).get();
		assertNotNull(employee);
		assertEquals("Maria Rawat", employee.getName());
	}

	@Test
	public void testEmpCount() {

		System.out.println("Count of rows---------->>" + employeeRepository.count());
	}

	@Test
	public void testEmpFindAllPaging() {
		Pageable pageable = PageRequest.of(0, 7);
		Page<Employee> results = employeeRepository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName() + "-------->" + p.getAge()));
	}

	@Test
	public void testEmpFindMultipleSorting() {
		employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name", "age"))   //direction,properties
				.forEach(p -> System.out.println(p.getName() + "--->" + p.getAge()));

	}

	@Test
	public void testEmpFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "age");

		employeeRepository.findAll(pageable)
				.forEach(p -> System.out.println(p.getName() + "---->" + p.getAge()));
	}

	@Test
	public void testEmpFindByName() {
		List<Employee> products = employeeRepository.findByName("Komal Rawat");
		products.forEach(p -> System.out.println(p.getId() + "--->" + p.getName()));
	}

	@Test
	public void testFindByNameStartingWithA_Like() {
		List<Employee> employee = employeeRepository.findByNameLike("A%");
		employee.forEach(p -> System.out.println(p.getId() + "--->" + p.getName()));
	}

	@Test
	public void testEmpFindByAgeBetween() {
		List<Employee> employee = employeeRepository.findByAgeBetween(28, 32);
		employee.forEach(p -> System.out.println(p.getName() + "--->" + p.getAge()));

	}



}
