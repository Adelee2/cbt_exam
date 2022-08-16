package com.cbt.portal.service;

import com.cbt.portal.service.jms.QueueSender;
import com.cbt.portal.service.vo.request.StudentAnswerRequest;

import javax.inject.Inject;

public class CbtService {
    @Inject
    private QueueSender queueSender;
    public void updateStudentAnswer(StudentAnswerRequest answerRequest){
        queueSender.sendToQueue(answerRequest,1224242,5352422);
    }
}
