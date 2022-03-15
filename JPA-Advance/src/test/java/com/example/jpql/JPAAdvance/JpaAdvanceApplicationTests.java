package com.example.jpql.JPAAdvance;

import com.example.jpql.JPAAdvance.componentMapping.entity.Employee2;
import com.example.jpql.JPAAdvance.componentMapping.entity.Salary;
import com.example.jpql.JPAAdvance.componentMapping.repository.Employee2Repository;
import com.example.jpql.JPAAdvance.employee.entity.Employee;
import com.example.jpql.JPAAdvance.employee.repository.EmployeeRepository;
import com.example.jpql.JPAAdvance.inheritance.entity.Check;
import com.example.jpql.JPAAdvance.inheritance.entity.CreditCard;
import com.example.jpql.JPAAdvance.inheritance.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class JpaAdvanceApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	Employee2Repository employee2Repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee employee=new Employee();
		employee.setAge(65);
		employee.setFirstName("Ria");
		employee.setLastName("x");
		employee.setSalary(15478.2d);
		repository.save(employee);

	}

	@Test
	public void testFindAllEmployee(){
		System.out.println(repository.findAllEmployees());
	}

	@Test
	public void testEmployeeGreaterThanAVGSalary() {
		List<Object[]> partialData = repository.findEmployeeSalaryGreaterThanAVGSalary();
		for (Object[] objects : partialData) {
			System.out.println("First Name: "+objects[0]+" Last Name: "+objects[1]);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateSalaryEmployee(){
		double avgSalary=repository.getAVGSalary();
		repository.updateSalaryGreaterThanAVGSalary(85993.56d,avgSalary);

	}


	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteEmployee(){
		double minSalary=repository.getMinSalary();
		repository.deleteEmployeeWithMinimumSalary(minSalary);
	}

	//Native Query


	@Test
	public void testFindAllStudentsNQ(){
		System.out.println(repository.findAllStudentNQ());
	}

	@Test
	public void testFindByLastNameNQ(){
		System.out.println(repository.findAllEmployeeByLastNameNQ());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteEmployeeGreaterThan45NQ(){
		repository.DeleteEmployeeGreaterThan45NQ(45);
	}


	//Inheritance
	@Test
	public void createPayment(){
		CreditCard cc=new CreditCard();
		cc.setId(21);
		cc.setAmount(58800.25);
		cc.setCardnumber("156416516");
		paymentRepository.save(cc);

	}

	@Test
	public void createChequePayment(){
		Check ch =new Check();
		ch.setId(24);
		ch.setAmount(58800.25);
		ch.setChecknumber("164+9879615");
		paymentRepository.save(ch);

	}

	//Component Mapping

	@Test
	public void testCreateEmployee2(){
		Employee2 employee = new Employee2();
		Salary salary=new Salary();
		employee.setId(1);
		employee.setFirstName("Komal");
		employee.setLastName("Rawat");
		employee.setAge(22);
		salary.setBasicSalary(25700.98d);
		salary.setBonusSalary(8000d);
		salary.setSpecialAllowanceSalary(90000.35d);
		salary.setTaxAmount(25000d);
		employee.setSalary(salary);
		employee2Repository.save(employee);


	}

}
