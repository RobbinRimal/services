package com.microservices.multiplication.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public final class User {
    private  final  String alias;

    private User(){

        alias=null;
    }
}
