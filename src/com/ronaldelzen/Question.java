package com.ronaldelzen;

/**
 * Created by ronal on 1/10/2017.
 */
public abstract class Question {
    String question;
    int goodAnswered = 0;
    int badAnswered = 0;

    public Question(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }


    public void addGoodAnswered()
    {
        goodAnswered ++;
    }

    public void addBadAnswered()
    {
        badAnswered ++;
    }

    public int getGoodAnswered()
    {
        return goodAnswered;
    }

    public int getBadAnswered()
    {
        return badAnswered;
    }


}
