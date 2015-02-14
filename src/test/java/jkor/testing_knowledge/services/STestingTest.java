package jkor.testing_knowledge.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.*;
import static org.junit.Assert.assertEquals;
import jkor.testing_knowledge.entities.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class STestingTest extends AbstractTransactionalJUnit4SpringContextTests
{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired private STesting sTesting;

    public Map<String, Integer> getNewInfo()
    {
        Map<String, Integer> info = new HashMap<String, Integer>();
        info.put("correctAnswers", 1);
        info.put("points", 8);
        info.put("questionNumber", 1);
        info.put("time", sTesting.getUnixtime());

        return info;
    }

    @Test
    public void testingCheck() throws Exception
    {
        Map<String, Integer>
                info = sTesting.getStartInfo(),
                newInfo = getNewInfo();

        Question question = new Question();
        question.setCorrectAnswerIds("5");

        sTesting.check(question, 5, 0, info);

        assertEquals(newInfo, info);
    }
}
