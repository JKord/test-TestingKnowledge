package jkor.testing_knowledge.model;

public class InfoTestingModel
{
    private int
            correctAnswers = 0,
            points = 0,
            questionNumber = 0,
            time = 0;

    public InfoTestingModel() {}

    public InfoTestingModel(int correctAnswers, int points, int questionNumber, int time)
    {
        this.correctAnswers = correctAnswers;
        this.points = points;
        this.questionNumber = questionNumber;
        this.time = time;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}