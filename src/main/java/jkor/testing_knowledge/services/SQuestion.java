package jkor.testing_knowledge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import jkor.testing_knowledge.entities.Question;
import jkor.testing_knowledge.dao.QuestionDAO;

@Service
public class SQuestion
{
    @Autowired
    QuestionDAO questionDAO;

    @Transactional
    public List<Question> listQuestion()
    {
        return questionDAO.list();
    }

    @Transactional
    public Question getById(long id)
    {        
        return questionDAO.getById(id);
    }
}
