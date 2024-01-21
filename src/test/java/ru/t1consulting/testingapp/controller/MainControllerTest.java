package ru.t1consulting.testingapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void countFrequenciesStatusOK() throws Exception {
        String str = "abbcccccdddeeee";
        String expected = "\"c\":5, \"e\":4, \"d\":3, \"b\":2, \"a\":1";
        ResultActions resultActions = mvc.perform(get("/api/v1/freqs")
            .content(str));

        MvcResult result = resultActions.andReturn();

        MockHttpServletResponse response = result.getResponse();
        String content = response.getContentAsString();
        assertEquals(expected, content);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void countFrequenciesStatus400WhenContentIsEmpty() throws Exception {
        String str = "";
        String expected = "";
        ResultActions resultActions = mvc.perform(get("/api/v1/freqs")
            .content(str));

        MvcResult result = resultActions.andReturn();

        MockHttpServletResponse response = result.getResponse();
        String content = response.getContentAsString();
        assertEquals(expected, content);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    public void countFrequenciesStatus400WhenContentIsNull() throws Exception {
        ResultActions resultActions = mvc.perform(get("/api/v1/freqs"));

        MvcResult result = resultActions.andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertTrue(response.getContentAsString().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }



}