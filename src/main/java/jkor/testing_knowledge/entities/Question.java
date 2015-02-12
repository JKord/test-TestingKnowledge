package jkor.testing_knowledge.entities;

import javax.persistence.*;
import java.util.Set;

public class Question extends BaseEntity
{
    @Column(name="text")
    private String text;

    @ElementCollection
    @Column(name="correct_answer_ids")
    private Set<Integer> correctAnswerIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<Question> answers;

    public String getText() {
        return text;
    }

    public Question setText(String text) {
        this.text = text;
        return this;
    }

    public Set<Integer> getCorrectAnswerIds() {
        return correctAnswerIds;
    }

    public Question setCorrectAnswerIds(Set<Integer> correctAnswerIds) {
        this.correctAnswerIds = correctAnswerIds;
        return this;
    }

    public boolean isCorrectAnswer(int id)
    {
        return correctAnswerIds.contains(id);
    }

    public Topic getTopic() {
        return topic;
    }

    public Question setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public Set<Question> getAnswers() {
        return answers;
    }

    public Question setAnswers(Set<Question> answers) {
        this.answers = answers;
        return this;
    }
}
