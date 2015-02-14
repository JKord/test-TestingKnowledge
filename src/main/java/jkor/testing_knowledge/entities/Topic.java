package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.Map;
import java.util.List;

@Entity
@Table(name="topic")
public class Topic extends BaseEntity
{
    @Column(name="name")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "topic")
    private List<Question> questions;

    public String getName() {
        return name;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }

    public Topic setQuestions(List<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Map<String, Object> responseObj()
    {
        return null;
    }
}
