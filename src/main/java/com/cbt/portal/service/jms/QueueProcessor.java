package com.cbt.portal.service.jms;

import com.cbt.portal.service.vo.request.StudentAnswerRequest;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig =
        {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "CBTQueue"),
                @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        })
public class QueueProcessor implements MessageListener {
    @Override
    public void onMessage (Message message)
    {
        ObjectMessage msg = (ObjectMessage) message;
        try {
            StudentAnswerRequest request = (StudentAnswerRequest) msg.getObject ();
            Long studentId = msg.getLongProperty ("studentId");
            Long courseId = msg.getLongProperty("courseId");
            updateStudentAnswer(request,studentId,courseId);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateStudentAnswer(StudentAnswerRequest studentAnswerRequest, Long studentId, Long courseId){

    }
}
