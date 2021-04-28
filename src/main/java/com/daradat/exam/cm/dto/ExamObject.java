package com.daradat.exam.cm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExamObject {
    private String question;

    private int cntOfChoices;

    private List<String> choices;

    private List<String> answer;

}
