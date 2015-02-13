package jkor.testing_knowledge.entities.dao;

import java.util.List;

import org.hibernate.Query;
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

    @Transactional
    public Question getById(long id)
    {
        Query query = getCurrentSession().createQuery("from Question where id = :id");
        query.setParameter("id", id);

        return (Question) query.uniqueResult();
    }
}