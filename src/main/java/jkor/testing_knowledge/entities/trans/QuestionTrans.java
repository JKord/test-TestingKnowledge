package jkor.testing_knowledge.entities.trans;

import javax.persistence.*;
import jkor.testing_knowledge.entities.Question;

@Entity
@Table(name="trans_question")
public class QuestionTrans extends Trans<Question>
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
