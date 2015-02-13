package jkor.testing_knowledge.entities.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import jkor.testing_knowledge.entities.Topic;

@Repository
public class TopicDAO  extends BaseDAO
{
    @Transactional
    public List<Topic> listTopic()
    {
        return getCurrentSession().createQuery("from Topic").list();
    }

    @Transactional
    public Topic getById(long id)
    {
        Query query = getCurrentSession().createQuery("from Topic where id = :id");
        query.setParameter("id", id);
        
        return (Topic) query.uniqueResult();
    }
}