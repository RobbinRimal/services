package com.microservices.multiplication.model;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.random.RandomGenerator;
@Service
public class RandomGeneratorServiceImpl  implements RandomGeneratorService {

    @Override
    public int generateRandomFactor() {
        return new Random().nextInt(11,99);
    }
}
