package com.daradat.exam.cm.interceptor;

import com.daradat.exam.cm.dto.Exam;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExamInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("exam") != null){
            return true;
        }
        Exam exam = new Exam();
        httpSession.setAttribute("exam", exam);
        return true;
    }
}
