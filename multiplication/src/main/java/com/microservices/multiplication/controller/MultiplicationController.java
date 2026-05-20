package com.microservices.multiplication.controller;

import com.microservices.multiplication.model.Multiplication;
import com.microservices.multiplication.model.MultiplicationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class MultiplicationController {
    @Autowired
    private final MultiplicationServiceImpl multiplicationService;

    @GetMapping("/random")
    public Multiplication getMultilpicationn() {

        return multiplicationService.createRandomMultiplication();

    }

    @GetMapping
    public String greetings() {

        return "Hello wrold";

    }


}


