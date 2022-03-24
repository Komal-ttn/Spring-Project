package com.example.jpql.JPAAdvance.inheritance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {

    @Id
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
