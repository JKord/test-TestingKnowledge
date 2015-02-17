package jkor.testing_knowledge.entities.trans;

import javax.persistence.*;
import jkor.testing_knowledge.entities.Answer;

@Entity
@Table(name="trans_answer")
public class AnswerTrans extends Trans<Answer>
{
    @Column(name="text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
