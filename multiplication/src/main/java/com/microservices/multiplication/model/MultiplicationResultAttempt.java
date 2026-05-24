package com.microservices.multiplication.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Component
public final class MultiplicationResultAttempt {
    private  final int resultAttempt;
    private final User user;
    private final Multiplication multiplication;
    private final boolean correct;

    public MultiplicationResultAttempt() {
        this(-1,null, null,false);


    }
}


