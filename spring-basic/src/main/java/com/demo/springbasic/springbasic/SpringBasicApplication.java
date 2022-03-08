package com.demo.springbasic.springbasic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {
	public static void main(String[] args) {
		//BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSortAlgo());
		//Now Spring will make bean for us
		ApplicationContext applicationContext= SpringApplication.run(SpringBasicApplication.class, args);




		BinarySearchImpl binarySearch=applicationContext.getBean(BinarySearchImpl.class);
		System.out.println(applicationContext.getDisplayName());
		System.out.println(applicationContext.getId());


		int result=binarySearch.binarySearch(new int[]{4,7,5,3,41,85},7);
		if(result==-1)
			System.out.println("Not found");
		else
			System.out.println("Found at index : "+result);
	}

}
