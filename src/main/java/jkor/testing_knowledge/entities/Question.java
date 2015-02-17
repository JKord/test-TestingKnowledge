package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.*;

import jkor.testing_knowledge.entities.trans.QuestionTrans;

@Entity
@Table(name="question")
public class Question extends BaseEntity<QuestionTrans>
{
    //@ElementCollection
    @Column(name="correct_answer_ids")
    private String correctAnswerIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<Answer> answers;

    public String getText() {
        return trans.get(getLocale()).getText();
    }

    public Question setText(String text) {
        trans.get(getLocale()).setText(text);
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
        String[] answerIds = correctAnswerIds.split(",");
        for (String aid : answerIds)
            if (String.valueOf(id).equals(aid))
                return true;
        return false;
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

        obj.put("text", getText());
        obj.put("answers", answersList);

        return obj;        
    }
}
