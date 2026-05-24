package com.microservices.multiplication.controller;

import com.microservices.multiplication.model.MultiplicationResultAttempt;
import com.microservices.multiplication.model.MultiplicationServiceImpl;
import com.microservices.multiplication.model.ResultResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    @Autowired
    MultiplicationServiceImpl multiplicationService;
    @PostMapping

    public  ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt resultAttempt) {
       var correct= multiplicationService.checkAttempt(resultAttempt);
        System.out.println(correct+ "the value of correct is ");
       var multiplicationAttemptCopy=new MultiplicationResultAttempt(
               resultAttempt.getResultAttempt(),
               resultAttempt.getUser(),
               resultAttempt.getMultiplication(),
               correct
       );
      return ResponseEntity.ok(multiplicationAttemptCopy);
    }
}
