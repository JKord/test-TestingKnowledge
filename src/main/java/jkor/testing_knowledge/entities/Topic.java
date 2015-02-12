package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="topic")
public class Topic extends BaseEntity
{
    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private Set<Question> questions;

    public String getName() {
        return name;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Topic setQuestions(Set<Question> questions) {
        this.questions = questions;
        return this;
    }
}
