package jkor.testing_knowledge.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import jkor.testing_knowledge.entities.Question;

@Service
public class STesting
{
    public int getUnixtime()
    {
        Date now = new Date();
        Long longTime = new Long(now.getTime() / 1000L);
        
        return longTime.intValue();
    }
    
    public Map<String, Integer> getStarInfo()
    {
        Map<String, Integer> info = new HashMap<String, Integer>();
        info.put("correctAnswers", 0);
        info.put("points", 0);
        info.put("time", getUnixtime());

        return info;        
    }
    
    public void checking(Question question, int answerId, Map<String, Integer> info)
    {       
        if(question.isCorrectAnswer(answerId)) {
            info.put("correctAnswers", info.get("correctAnswers") + 1);
            info.put("points", info.get("points") + 8);
            info.put("time", getUnixtime());
        }
    }
}
