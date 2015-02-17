package jkor.testing_knowledge.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;
import jkor.testing_knowledge.entities.Question;
import jkor.testing_knowledge.model.InfoTestingModel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestingServiceTest extends AbstractTransactionalJUnit4SpringContextTests
{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired private TestingService sTesting;

    public InfoTestingModel getNewInfo() {
        return  new InfoTestingModel(1, 8, 1, sTesting.getUnixtime());
    }

    @Test
    public void testingCheck() throws Exception
    {
        InfoTestingModel
                info = sTesting.getStartInfo(),
                newInfo = getNewInfo();

        Question question = new Question();
        question.setCorrectAnswerIds("5");

        sTesting.check(question, 5, 0, info);

        assertEquals(newInfo, info);
    }
}
