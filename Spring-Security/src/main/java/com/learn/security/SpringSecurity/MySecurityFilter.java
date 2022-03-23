package com.learn.security.SpringSecurity;

import jakarta.servlet.*;

import java.io.IOException;

public class MySecurityFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Coming from request");
        chain.doFilter(request,response);
        System.out.println("Going to request");

    }


}
