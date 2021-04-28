package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Resource(name="exam")
    private Exam exam;

    @RequestMapping("index")
    public String indexView(HttpServletRequest request){
        System.out.println(exam);
        return "index";}
}
