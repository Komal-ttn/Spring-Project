package com.learn.security.SpringSecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testPasswordEncoder(){
		System.out.println(new BCryptPasswordEncoder().encode("password"));

		System.out.println(new Pbkdf2PasswordEncoder().encode("password"));

		System.out.println(new SCryptPasswordEncoder().encode("password"));
		Map<String, PasswordEncoder> encoders=new HashMap<>();
		encoders.put("bcrypt",new BCryptPasswordEncoder());
		encoders.put("scrypt",new SCryptPasswordEncoder());

		System.out.println(new DelegatingPasswordEncoder("bcrypt",encoders).encode("password"));
	}

}
