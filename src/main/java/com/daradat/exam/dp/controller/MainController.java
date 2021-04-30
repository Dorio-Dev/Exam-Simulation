package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import com.daradat.exam.cm.dto.ExamObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {

//    @Resource(name="exam")
//    private Exam exam;

    @RequestMapping("index")
    public ModelAndView indexView(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        //mv.addObject("a", exam);

        return mv;
    }

    @GetMapping("/exam")
    public ModelAndView examView(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        //mv.addObject("exam", exam.getExamList().get(0));
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        mv.addObject("exam", exam.getExamList().get(0));
        mv.addObject("examIndex", 1);
        mv.setViewName("exam");
        return mv;
    }

    @PostMapping("/exam/{examIndex}")
    public ExamObject exam(HttpServletRequest request, @PathVariable int examIndex, @RequestParam Map param){
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        //정답 체크
        ExamObject currentExam = exam.getExamList().get(examIndex);





        //다음문제 리턴
        return exam.getExamList().get(examIndex+1);
    }
//
//    @GetMapping("detail/{boardId}")
//    public ModelAndView detail(@PathVariable int boardId){
//        ModelAndView mv = new ModelAndView();
//        BoardDto boardDto = boardService.searchById(boardId);
//        boardService.updateViewCnt(boardId);
//
//        mv.setViewName("detail");
//        mv.addObject("details", boardDto);
//
//        return mv;
//    }
}
