package com.learn.jpa.JpaDemo.extraExercise.customIdGenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomRandomIDGenerator implements IdentifierGenerator {
    @Override       //whatever this method return will be used as custom id
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        Random random=null;
        Long id;
        random=new Random();
        id= Long.valueOf(random.nextInt(10000));
        return id;
    }
}
