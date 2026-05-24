package com.microservices.multiplication.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode


@RequiredArgsConstructor
@Entity
public final class Multiplication {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "MultiplicationId")
    private  Long id;
    private final int factorA;
    private final int factorB;

    public Multiplication() {
        this(0, 0);
    }

//    public Multiplication(int factorA, int factorB) {
//        this.factorA = factorA;
//        this.factorB = factorB;
//        this.result = factorA * factorB;
//   }
}
