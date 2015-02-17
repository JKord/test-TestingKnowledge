package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.Map;

import jkor.testing_knowledge.entities.trans.AnswerTrans;

@Entity
@Table(name="answer")
public class Answer extends BaseEntity<AnswerTrans>
{
    @Column(name="text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public String getText() {
        if(text == null)
            return trans.get(getLocale()).getText();
        return text;
    }

    public Answer setText(String text) {
        this.text = text;
        return this;
    }

    public Answer setText(String codeLocale, String text) {
        trans.get(codeLocale).setText(text);
        return this;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public Map<String, Object> responseObj()
    {
        return null;
    }
}
