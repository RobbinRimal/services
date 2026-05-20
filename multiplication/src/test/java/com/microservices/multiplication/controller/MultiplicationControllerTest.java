package com.microservices.multiplication.controller;

import com.microservices.multiplication.model.Multiplication;
import com.microservices.multiplication.model.MultiplicationServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.Before;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationController.class)

class MultiplicationControllerTest {
    @MockitoBean
    MultiplicationServiceImpl multiplicationService;
    @Autowired
    MockMvc mockMvc;




    private JacksonTester<Multiplication> json;

    @BeforeEach
    public void setup() {
        JsonMapper jsonMapper = new JsonMapper();
        JacksonTester.initFields(this, jsonMapper);

    }


    @Test
    void getMultilpicationn() throws Exception {

        /***
         * given
         */


        when(multiplicationService.createRandomMultiplication()).thenReturn(new Multiplication(20, 20));
        /**
        * when
        */
        var response = mockMvc.perform(
                get("/message/random")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        /**
         *
         * than
         */

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(json.write(new Multiplication(20,20)).getJson());

    }
}