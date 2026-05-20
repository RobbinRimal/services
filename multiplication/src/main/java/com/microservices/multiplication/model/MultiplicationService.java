package com.microservices.multiplication.model;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();
   boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
