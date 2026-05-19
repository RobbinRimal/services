package com.microservices.multiplication;

import com.microservices.multiplication.model.Multiplication;
import com.microservices.multiplication.model.MultiplicationServiceImpl;
import com.microservices.multiplication.model.RandomGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
class MultiplicationApplicationTests {

    @Autowired
    MultiplicationServiceImpl multiplicationService;
    @MockitoBean
    RandomGeneratorService randomGeneratorService;

    @Test
    void contextLoads() {
        //given
given(randomGeneratorService.generateRandomFactor()).
                willReturn(50, 30);
//when
       Multiplication multiplication = multiplicationService.
                createRandomMultiplication();

       //than

        assertThat(multiplication.getFactorA()).isEqualTo(50);
assertThat(multiplication.getFactorB()).isEqualTo(30);
assertThat(multiplication.getResult()).isEqualTo(1500);


    }

}
