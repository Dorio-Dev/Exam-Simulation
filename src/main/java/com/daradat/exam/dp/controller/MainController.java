package com.daradat.exam.dp.controller;

import com.daradat.exam.cm.dto.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Resource(name="exam")
    private Exam exam;

    @RequestMapping("index")
    public ModelAndView indexView(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        mv.addObject("a", exam);

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
