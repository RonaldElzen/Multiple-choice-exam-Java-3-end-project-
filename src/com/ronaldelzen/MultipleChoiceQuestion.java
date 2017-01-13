package com.ronaldelzen;

/**
 * Created by ronal on 1/10/2017.
 */
public class MultipleChoiceQuestion extends Question
{
 String[] answers = new String[4];

    int  rightAnswer;

    public MultipleChoiceQuestion(String question, String[] answers, int rightAnswer)
    {
        super(question);
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }


    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers)
    {
        this.answers = answers;
    }

    public int getRightAnswer()
    {
        int answer = rightAnswer;
        return answer;
    }

    public void setRightAnswer(int rightAnswer)
    {
        this.rightAnswer = rightAnswer;
    }
}
