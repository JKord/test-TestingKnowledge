package jkor.testing_knowledge.services;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import jkor.testing_knowledge.entities.Question;

@Service
public class TestingService
{
    private final int TIME_INTERVAL = 30;
    private final int POINT = 8;

    int getUnixtime() {
        return new Long(new Date().getTime() / 1000L).intValue();
    }
    
    public Map<String, Integer> getStartInfo() {
        Map<String, Integer> info = new HashMap<String, Integer>();
        info.put("correctAnswers", 0);
        info.put("points", 0);
        info.put("questionNumber", 0);
        info.put("time", getUnixtime());

        return info;        
    }
    
    public void check(Question question, int answerId, int questionNumber, Map<String, Integer> info)
    {
        if(question.isCorrectAnswer(answerId) && (info.get("time") + TIME_INTERVAL) > getUnixtime() &&
           info.get("questionNumber").equals(questionNumber)
          ) {
            info.put("correctAnswers", info.get("correctAnswers") + 1);
            info.put("points", info.get("points") + POINT);
        }
        info.put("questionNumber", info.get("questionNumber") + 1);
        info.put("time", getUnixtime());
    }
}