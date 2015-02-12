package jkor.testing_knowledge.entities.dao;

import java.util.List;
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
}