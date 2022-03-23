package com.learn.security.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyAuthenticationProvider authenticationProvider;
 /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  //customize auth manager
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("komal").password(passwordEncoder.encode("rawat")).authorities("read").build();
        userDetailsService.createUser(user);

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }*/


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  //customize auth manager
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {      //what security we want to use

        http.httpBasic();
        http.authorizeRequests().antMatchers("/hello").authenticated();//.anyRequest().denyAll();
        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
