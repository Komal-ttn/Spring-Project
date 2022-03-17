package com.learn.jpa3.JPA3.extraQuestion;

import com.learn.jpa3.JPA3.extraQuestion.associations.manytomany.entity.Programmer;
import com.learn.jpa3.JPA3.extraQuestion.associations.manytomany.entity.Project;
import com.learn.jpa3.JPA3.extraQuestion.associations.manytomany.repository.ProgrammerRepository;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetomany.entities.Customer;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetomany.entities.PhoneNumber;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetomany.repository.CustomerRepository;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetoone.entity.License;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetoone.entity.Person;
import com.learn.jpa3.JPA3.extraQuestion.associations.onetoone.repository.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class Jpa3ApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer(){
		Customer customer=new Customer();
		//HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();


		customer.setName("Komal");

		PhoneNumber ph1=new PhoneNumber();
		ph1.setNumber("15468795");
		ph1.setType("Mobile");



		PhoneNumber ph2=new PhoneNumber();
		ph2.setNumber("879461213");
		ph2.setType("Home");
		//ph2.setCustomer(customer);
		//numbers.add(ph2);


		//customer.setNumbers(numbers);

		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}
	
	
	@Test
	@Transactional
	public void testLoadCustomer(){
		Customer customer = repository.findById(4).get();
		System.out.println(customer.getName());

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));

	}

	@Test
	public void testUpdateCustomer(){
		Customer customer = repository.findById(4).get();
		customer.setName("Komal Rawat");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number -> number.setType("celll"));

		repository.save(customer);

	}

	@Test
	public void testDelete(){
		repository.deleteById(4);
	}

	//Many to many


	@Test
	public void testMTMCreateProgrammer(){
		Programmer programmer=new Programmer();
		Project project = new Project();
		programmer.setName("Komal");
		programmer.setSalary(95000);
		HashSet<Project> projects = new HashSet<>();

		project.setName("Hibernate Project");
		projects.add(project);
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
	}

	@Test
	@Transactional
	public void testLoadMTMProgrammer(){
		Programmer programmer = programmerRepository.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	//One to one

	@Test
	public void testOTOcreateLicense(){
		License license = new License();
		Person person = new Person();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());

		person.setFirstName("Komal");
		person.setLastName("Rawat");
		person.setAge(22);

		license.setPerson(person);
		licenseRepository.save(license);



	}

}
