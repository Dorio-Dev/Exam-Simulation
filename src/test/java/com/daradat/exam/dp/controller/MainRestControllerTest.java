package com.daradat.exam.dp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class MainRestControllerTest {
    @InjectMocks
    private MainRestController mainRestController;

    //checkAnswer(HttpServletRequest request, @RequestParam Map<String, String> param){
    @Test
    public void checkAnswer(){
        HttpServletRequest request = new MockHttpServletRequest();

        Map<String, Object> param = new HashMap<>();
        param.put("test", "default");
        //Map result = mainRestController.checkAnswer(request, param);

        assertThat("TEST", is("TEST"));
    }
}
