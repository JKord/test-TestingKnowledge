package jkor.testing_knowledge.services;

import jkor.testing_knowledge.dao.TopicDAO;
import jkor.testing_knowledge.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService
{
    @Autowired
    TopicDAO topicDAO;

    public List<Topic> listTopic() {
        return topicDAO.list();
    }

    public Topic getById(long id) {
        return topicDAO.getById(id);
    }
}