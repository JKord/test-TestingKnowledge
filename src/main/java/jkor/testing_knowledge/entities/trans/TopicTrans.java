package jkor.testing_knowledge.entities.trans;

import javax.persistence.*;
import jkor.testing_knowledge.entities.Topic;

@Entity
@Table(name="trans_topic")
public class TopicTrans extends Trans<Topic>
{
    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}