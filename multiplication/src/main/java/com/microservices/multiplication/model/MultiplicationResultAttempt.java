package com.microservices.multiplication.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public final class MultiplicationResultAttempt {
    private  final int resultAttempt;
    private final User user;
    private final Multiplication multiplication;

    public MultiplicationResultAttempt() {
        this(-1,null, null);

    }
}


