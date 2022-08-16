package com.cbt.portal.service.jms;

import com.cbt.portal.service.vo.request.StudentAnswerRequest;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueSender {
    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "java:/jms/queue/CBTQueue")
    private Queue cbtAnswerQueue;
    private Connection connection = null;
    private Session session = null;
    private MessageProducer producer;

    public void sendToQueue (StudentAnswerRequest studentAnswerRequest, long studentId, long courseId)
    {
        Connection connection = null;
        Session session = null;
        try
        {
            connection = connectionFactory.createConnection ();
            session = connection.createSession (false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer (cbtAnswerQueue);

            ObjectMessage message = session.createObjectMessage ();
            message.setObject (studentAnswerRequest);
            message.setLongProperty ("studentId", studentId);
            message.setLongProperty("courseId",courseId);

            producer.send (message);
        } catch (JMSException ex)
        {
            log (String.format ("Error adding search data to queue - %s", studentAnswerRequest.getAnswer (), ex.getMessage ()));
        } finally
        {
            if (session != null)
            {
                try
                {
                    session.close ();
                } catch (JMSException e)
                {
                    log (e.getMessage ());
                }
            }

            if (connection != null)
            {
                try
                {
                    connection.close ();
                } catch (JMSException e)
                {
                    log (e.getMessage ());
                }
            }
        }
    }

    public void log (String message)
    {
        java.util.logging.Logger LOGGER = Logger.getLogger (QueueSender.class.getName ());
        LOGGER.log (Level.INFO, message);
    }
}
