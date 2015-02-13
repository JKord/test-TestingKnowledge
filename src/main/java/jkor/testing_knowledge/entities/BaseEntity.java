package jkor.testing_knowledge.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Map;

@MappedSuperclass
public abstract class BaseEntity implements Serializable
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
    
    public abstract Map<String, Object> responseObj();
}
