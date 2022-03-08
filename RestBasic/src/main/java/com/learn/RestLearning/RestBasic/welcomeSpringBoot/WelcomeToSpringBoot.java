package com.learn.RestLearning.RestBasic.welcomeSpringBoot;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeToSpringBoot {

    //@RequestMapping(method = RequestMethod.GET,path = "/welcome")      OR
    @GetMapping(path = "/welcome")           //mapping Get request for the method to URI
    public String getWelcome(){      return "Welcome to Spring Boot";    }

    //Return Bean Back
    @GetMapping(path = "/welcome-bean")
    public SpringBootBean getWelcomeBean(){
        return new SpringBootBean("Welcome to Spring Boot");
    }

    //Path Variable
    @GetMapping(path = "/welcome/pathvariable/{name}")
    public SpringBootBean getWelcomePathVariable(@PathVariable String name){
        return new SpringBootBean(String.format("Welcome to Spring Boot %s",name));
    }
}
