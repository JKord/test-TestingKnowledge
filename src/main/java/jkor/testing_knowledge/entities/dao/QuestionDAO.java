package jkor.testing_knowledge.entities.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import jkor.testing_knowledge.entities.Question;

@Repository
public class QuestionDAO extends BaseDAO
{
    @Transactional
    public List<Question> listQuestion()
    {
        return getCurrentSession().createQuery("from Question").list();
    }
}