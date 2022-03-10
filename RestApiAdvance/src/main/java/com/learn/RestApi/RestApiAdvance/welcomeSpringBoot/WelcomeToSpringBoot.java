package com.learn.RestApi.RestApiAdvance.welcomeSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeToSpringBoot {

    @Autowired
    private ResourceBundleMessageSource messageSource;

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
    @GetMapping(path = "/welcome-internationalized")           //mapping Get request for the method to URI
    public String getWelcomeInternationalized(){
        return messageSource.getMessage("welcome.message",null,
                LocaleContextHolder.getLocale());

    }

    @GetMapping(path = "/welcome-internationalized/{name}")           //mapping Get request for the method to URI
    public String getWelcomeInternationalizedPath(@PathVariable String name){
        return messageSource.getMessage("welcome.message", new Object[]{name},
                LocaleContextHolder.getLocale());

    }

}
