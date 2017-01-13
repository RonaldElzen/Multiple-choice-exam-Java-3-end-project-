package com.ronaldelzen;

import java.util.*;

/**
 * Created by ronal on 1/5/2017.
 */
public class MultipleChoiceExam   {
    private ArrayList<MultipleChoiceQuestion> questions;

    /**
     * constructor for MultipleChoiceExam
     */
    public MultipleChoiceExam()
    {
        questions = new ArrayList<>();
    }

    /**
     * Method to add a question to the exam
     * @param question
     */
    public void addQuestion(MultipleChoiceQuestion question) {
        questions.add(question);
    }


    public ArrayList<MultipleChoiceQuestion> getQuestions()
    {
        return questions;
    }

    /**
     * Method to get the number of questions
     * @return number of questions
     */
    public int getNumberOfQuestions() {
        return questions.size();
    }

    /**
     * Method to get a question
     * @param index
     * @return question
     */
    public MultipleChoiceQuestion getQuestion(int index) {
        return questions.get(index);
    }
}