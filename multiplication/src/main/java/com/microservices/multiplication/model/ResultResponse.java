package com.microservices.multiplication.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class ResultResponse {
    private  final boolean correct;
}
