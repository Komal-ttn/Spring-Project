package com.learn.Jpql.JpqlDemo;


import com.learn.Jpql.JpqlDemo.student.entity.Student;
import com.learn.Jpql.JpqlDemo.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
public class JpqlDemoApplicationTests {

	@Autowired
	StudentRepository repository;


	@Test
	void contextLoads() {
	}

	@Test
	public void testStudent(){
		Student student=new Student();
		student.setFirstName("Komal");
		student.setLastName("Rawat");
		student.setScore(100);

		Student student2=new Student();
		student2.setFirstName("Maria");
		student2.setLastName("Rawat");
		student2.setScore(90);

		Student student3=new Student();
		student3.setFirstName("Lily");
		student3.setLastName("Sweet");
		student3.setScore(85);

		Student student4=new Student();
		student4.setFirstName("Mitsu");
		student4.setLastName("Nohara");
		student4.setScore(40);

		repository.save(student);
		repository.save(student2);
		repository.save(student3);
		repository.save(student4);
	}

	/*@Test
	public void testFindAllStudents(){
		System.out.println(repository.findAllStudents());
	}*/


	/*@Test
	public void testFindAllStudents(){
		System.out.println(repository.findAllStudents(PageRequest.of(1, 4)));
	}*/

	@Test
	public void testFindAllStudents(){
		System.out.println(repository.findAllStudents(PageRequest.of(0, 4, Sort.Direction.DESC,"id")));
	}


	@Test
	public void testFindAllStudentsPartialData(){
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for(Object[] objects: partialData){
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	//Named Query Param
	@Test
	public void testFindAllStudentsByFirstName(){
		System.out.println(repository.findAllStudentsByFirstName("Komal"));
	}

	@Test
	public void testFindAllStudentsByScores(){
		System.out.println(repository.findStudentsForGivenScores(50,90));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentsByFirstName(){
		repository.deleteStudentByFirstName("Maria");

	}

	//NativeQuery

	@Test
	public void testFindAllStudentsNQ(){
		System.out.println(repository.findAllStudentNQ());
	}

	@Test
	public void testFindByFirstNameNQ(){
		System.out.println(repository.findAllStudentsByFirstName("Komal"));
	}





}
