package jkor.testing_knowledge.services;

import java.util.Date;

import org.springframework.stereotype.Service;
import jkor.testing_knowledge.entities.Question;
import jkor.testing_knowledge.model.InfoTestingModel;

@Service
public class TestingService
{
    private final int TIME_INTERVAL = 30;
    private final int POINT = 8;

    int getUnixtime() {
        return new Long(new Date().getTime() / 1000L).intValue();
    }
    
    public InfoTestingModel getStartInfo() {
        InfoTestingModel info = new InfoTestingModel();
        info.setTime(getUnixtime());

        return info;        
    }
    
    public void check(Question question, int answerId, int questionNumber, InfoTestingModel info)
    {
        if(question.isCorrectAnswer(answerId) && (info.getTime() + TIME_INTERVAL) > getUnixtime() &&
           info.getQuestionNumber() == questionNumber
          ) {
            info.setCorrectAnswers(info.getCorrectAnswers() + 1);
            info.setPoints( info.getPoints() + POINT);
        }
        info.setQuestionNumber(info.getQuestionNumber() + 1);
        info.setTime(getUnixtime());
    }
}