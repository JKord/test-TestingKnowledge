package jkor.testing_knowledge.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import jkor.testing_knowledge.entities.Topic;

@Repository
public class TopicDAO  extends BaseDAO
{
    public List<Topic> list()
    {
        return getCurrentSession().createQuery("from Topic").list();
    }
    
    public Topic getById(long id)
    {
        Query query = getCurrentSession().createQuery("from Topic where id = :id");
        query.setParameter("id", id);
        
        return (Topic) query.uniqueResult();
    }
}