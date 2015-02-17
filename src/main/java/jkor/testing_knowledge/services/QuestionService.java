package jkor.testing_knowledge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import jkor.testing_knowledge.entities.Question;
import jkor.testing_knowledge.dao.QuestionDAO;

@Service
public class QuestionService
{
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> listQuestion()
    {
        return questionDAO.list();
    }

    public Question getById(long id)
    {        
        return questionDAO.getById(id);
    }
}
