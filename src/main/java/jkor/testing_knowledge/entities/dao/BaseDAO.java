package jkor.testing_knowledge.entities.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO
{
    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getCurrentSession()
    {
        return  sessionFactory.getCurrentSession();
    }
}
