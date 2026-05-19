package com.microservices.multiplication.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RandomGeneratorServiceTest {

    RandomGeneratorService randomGeneratorService;
    @Autowired
    public RandomGeneratorServiceTest(RandomGeneratorServiceImpl randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Test
   void randomGeneratorServiceTest(){
      List<Integer>  randomList=IntStream.range(0,1000).map(x->randomGeneratorService.generateRandomFactor()).boxed().toList();
      randomList.forEach(x->assertTrue(x>=11&&x<99, x+" failed the test"));
    }


}