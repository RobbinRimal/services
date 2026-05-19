package com.microservices.multiplication.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Multiplication {

    int factorA;
    int factorB;
    int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result= factorA * factorB;
    }
}
