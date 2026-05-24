package com.microservices.multiplication.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@RunWith(SpringRunner.class)

class MultiplicationServiceImplTest {

    MultiplicationServiceImpl multiplicationService = new MultiplicationServiceImpl(new RandomGeneratorServiceImpl());


    MultiplicationResultAttempt multiplicationResultAttempt;


    @Test
    void createRandomMultiplication() {
    }

    @Test
    void checkAttempt() {

        //given

        multiplicationResultAttempt =
                new MultiplicationResultAttempt(500, new User("ross"), new Multiplication(50, 10),false);

        //when
        var attempt = multiplicationService.checkAttempt(multiplicationResultAttempt);

        //than


        assertTrue(attempt, "this should return true ");


        //given
        multiplicationResultAttempt =
                new MultiplicationResultAttempt(510, new User("ross"), new Multiplication(50, 10),false);
        //when
        var falseAttempt = multiplicationService.checkAttempt(multiplicationResultAttempt);
        assertFalse(falseAttempt, "this should return False ");




    }
}