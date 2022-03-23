package com.learn.security.SecurityJPA.microservice.security;

public interface SecurityService {

    boolean login(String userName,String password);
}
