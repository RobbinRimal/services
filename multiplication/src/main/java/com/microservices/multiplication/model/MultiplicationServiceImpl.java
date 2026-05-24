package com.microservices.multiplication.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.
                generateRandomFactor();
        int factorB = randomGeneratorService.
                generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }


    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        var correct =resultAttempt.getMultiplication().getFactorA()*resultAttempt.getMultiplication().getFactorB()== resultAttempt.getResultAttempt()?true: false;


        Assert.isTrue(!resultAttempt.isCorrect(), "you can't sent result mark as is correct ");
//        System.out.println(correct);
        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(
                        resultAttempt.getResultAttempt(),
                        resultAttempt.getUser(),
                        resultAttempt.getMultiplication(),
                        correct
                );
//        System.out.println(checkedAttempt);

        return correct;

    }
}



