package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="question")
public class Question extends BaseEntity
{
    @Column(name="text")
    private String text;

    //@ElementCollection
    @Column(name="correct_answer_ids")
    private String correctAnswerIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private Set<Answer> answers;

    public String getText() {
        return text;
    }

    public Question setText(String text) {
        this.text = text;
        return this;
    }

    public String getCorrectAnswerIds() {
        return correctAnswerIds;
    }

    public Question setCorrectAnswerIds(String correctAnswerIds) {
        this.correctAnswerIds = correctAnswerIds;
        return this;
    }

    public boolean isCorrectAnswer(int id)
    {
        //return correctAnswerIds.contains(id);
        return true;
    }

    public Topic getTopic() {
        return topic;
    }

    public Question setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public Question setAnswers(Set<Answer> answers) {
        this.answers = answers;
        return this;
    }
    
    public Map<String, Object> responseObj()
    {
        Map<String, Object> obj = new HashMap<String, Object>();
        List<Map<String, Object>> answersList = new ArrayList<Map<String, Object>>();
        
        for (Answer answer : answers) {
            Map<String, Object> ans = new  HashMap<String, Object>();
            ans.put("id", answer.getId());
            ans.put("text", answer.getText());
            answersList.add(ans);
        }

        obj.put("text", text);          
        obj.put("answers", answersList);

        return obj;        
    }
}
