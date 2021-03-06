package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import com.daradat.exam.cm.dto.ExamObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
        mv.addObject("examIndex", 0);
        mv.setViewName("exam");
        return mv;
    }

    @GetMapping("/exam/{examIndex}")
    public ModelAndView exam(HttpServletRequest request, @PathVariable int examIndex){
        ModelAndView mv = new ModelAndView();
        //mv.addObject("exam", exam.getExamList().get(0));
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        mv.addObject("exam", exam.getExamList().get(examIndex));
        mv.addObject("examIndex", examIndex);
        mv.setViewName("exam");
        return mv;
    }

    @GetMapping("/explore")
    public ModelAndView examList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        //mv.addObject("exam", exam.getExamList().get(0));
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        mv.addObject("examList", exam.getExamList());
        //mv.addObject("examIndex", 0);
        mv.setViewName("list");
        return mv;
    }

    @GetMapping("/explore/shuffle")
    public ModelAndView examListShuffle(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        Exam exam = (Exam) request.getSession().getAttribute("exam");
        exam.shuffle();
        mv.addObject("examList", exam.getExamList());
        //mv.addObject("examIndex", 0);
        mv.setViewName("list");
        return mv;
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
