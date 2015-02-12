package jkor.testing_knowledge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BaseEntity
{
    @Id
    @GeneratedValue
    protected Long id;

    public Long getId()
    {
        return id;
    }

    public BaseEntity setId(Long id)
    {
        this.id = id;
        return this;
    }
}
