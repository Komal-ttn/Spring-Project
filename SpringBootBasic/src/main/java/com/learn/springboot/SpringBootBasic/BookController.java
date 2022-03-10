package com.learn.springboot.SpringBootBasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Arrays.asList(new Book(74,"SpringBoot Basic","Komal Rawat"),
                new Book(11,"Life is Fun","Maria")
                );

    }
}
