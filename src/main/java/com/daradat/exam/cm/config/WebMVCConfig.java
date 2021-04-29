package com.daradat.exam.cm.config;

import com.daradat.exam.cm.interceptor.ExamInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        ExamInterceptor examInterceptor = new ExamInterceptor();
        registry.addInterceptor(examInterceptor);

    }
}