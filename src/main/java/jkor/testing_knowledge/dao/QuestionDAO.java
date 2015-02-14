package jkor.testing_knowledge.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import jkor.testing_knowledge.entities.Question;

@Repository
public class QuestionDAO extends BaseDAO
{
    public List<Question> list()
    {
        return getCurrentSession().createQuery("from Question").list();
    }

    public Question getById(long id)
    {
        Query query = getCurrentSession().createQuery("from Question where id = :id");
        query.setParameter("id", id);

        return (Question) query.uniqueResult();
    }
}