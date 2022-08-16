package com.cbt.portal.service.vo.request;

import java.io.Serializable;

public class StudentAnswerRequest implements Serializable {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
