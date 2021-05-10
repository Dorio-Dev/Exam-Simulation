package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainRestController {
    @PostMapping("/exam/{examIndex}")
    public Map exam(HttpServletRequest request, @PathVariable int examIndex, @RequestParam Map param){
        Map result = new HashMap();
        Exam exam = (Exam) request.getSession().getAttribute("exam");

        result.put("exam", exam.getExamList().get(examIndex));
        result.put("examIndex", examIndex+1);
        return result;
    }

    @GetMapping("/exam/answer")
    public Map<String, Object> checkAnswer(HttpServletRequest request, @RequestParam Map<String, String> param){
        Map<String, Object> result = new HashMap();
        Exam exam = (Exam) request.getSession().getAttribute("exam");

        result.put("answer", exam.getExamList().get(Integer.parseInt(param.get("examIndex"))).getAnswer());

        return result;
    }
}
