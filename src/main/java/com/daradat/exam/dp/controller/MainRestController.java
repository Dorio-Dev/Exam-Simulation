package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainRestController {
    @GetMapping("/exam/{examIndex}")
    public Map exam(HttpServletRequest request, @PathVariable int examIndex, @RequestParam Map param){
        Map result = new HashMap();
        Exam exam = (Exam) request.getSession().getAttribute("exam");

        result.put("exam", exam.getExamList().get(examIndex));
        result.put("examIndex", examIndex+1);
        //다음문제 리턴
        return result;
    }
}
