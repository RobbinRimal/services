package com.microservices.multiplication.controller;

import com.microservices.multiplication.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;

import java.net.URI;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
class MultiplicationResultAttemptControllerTest {
    @MockitoBean
    MultiplicationServiceImpl multiplicationService;
    @Autowired
    MockMvc mockMvc;


    private JacksonTester<MultiplicationResultAttempt> multiplicationResultAttemptJacksonTester;
    private JacksonTester<MultiplicationResultAttempt> resultResponseJacksonTester;

    @BeforeEach
    public void setup() {
        JsonMapper jsonMapper = new JsonMapper();
        JacksonTester.initFields(this, jsonMapper);

    }


    @Test
    void postResult() throws Exception {

genericParameterizedTest(false,150);


    }


    public void genericParameterizedTest(final boolean correct ,final int x) throws Exception {

        var attempt = new MultiplicationResultAttempt(x, new User("ross"), new Multiplication(150, 10),true);
        //given
      //  given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(correct);


        //when
        var postRequest = mockMvc.perform(
                post(URI.create("/results")).contentType(MediaType.APPLICATION_JSON)
                        .content(multiplicationResultAttemptJacksonTester.write(attempt).getJson())
        ).andReturn().getResponse();



        assertThat(postRequest.getStatus()).isEqualTo(HttpStatus.OK.value());

        assertThat(postRequest.getContentAsString()).isEqualTo(resultResponseJacksonTester.write(new MultiplicationResultAttempt(
                attempt.getResultAttempt(),attempt.getUser(),attempt.getMultiplication(),correct
        )).getJson());


    }
}