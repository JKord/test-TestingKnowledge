package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import jkor.testing_knowledge.entities.trans.TopicTrans;

@Entity
@Table(name="topic")
public class Topic extends BaseEntity<TopicTrans>
{
    @Column(name="count_questions")
    private int countQuestions;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Question> questions;

    public String getName() {
        return trans.get(getLocale()).getName();
    }

    public Topic setName(String name) {
        trans.get(getLocale()).setName(name);
        return this;
    }

    public int getCountQuestions() {
        return countQuestions;
    }

    public Topic setCountQuestions(int countQuestions) {
        this.countQuestions = countQuestions;
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
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("name", getName());
        
        return obj;
    }
}