package com.ronaldelzen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ronal on 1/10/2017.
 */
public class ExamController
{
    private MultipleChoiceExam exam;
    private Student student;
    private Administration administration;
    private int questionCount;
    private ExamView view;
    private ArrayList<String> answers = new ArrayList<>();
    private ActionListener submitListener;
    /**
     * Constructor for ExamController
     * @param student
     * @param administration
     */
    public ExamController(Student student, Administration administration)
    {
        this.student = student;
        this.administration = administration;

        questionCount = 0;
        setSubmitListener();
        view = new ExamView(submitListener);
        initView();
    }


    /**
     * Method to set submit listener
     */
    public void setSubmitListener()
    {
        //Add actionListener to submit button
      submitListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Check if the input is not null
                if (view.getGivenAnswer() != null && !Objects.equals(view.getGivenAnswer(), "")) {

                    //Save answer
                    answers.add(view.getGivenAnswer());
                    //Increment of counter
                    questionCount++;

                    //If questionCount reaches the number of questions, exam is done
                    if (questionCount >= exam.getNumberOfQuestions()) {
                        //Add students answers to administration
                        administration.addTakenExam(student, answers,exam);

                        //Calculate grade
                        double grade = administration.calculateGrade(answers, exam);

                        view.showGradePanel(grade,administration.getCheckedAnswers(answers,exam));
                        view.showGrade(grade,administration.isPassed(grade));
                    }
                    //Else, show new question
                    else {

                        updateQuestion();
                    }

                }
                //Give error if answer is not filled in
                else
                {
                    view.showPopUp("Please enter an answer");
                }
            }
        };
    }
    /**
     * Method to intialize view
     */
    public void initView()
    {
        //Check if exam is set.
        if (exam != null)
        {
            //Show new question
            updateQuestion();
        }


        //Show popup where user must enter exam
        else
            {
            view.selectExamPopUp(administration.getAvailableExamNames());
                //Check if exam name is filled in.
            if(view.getExamName() != null)
            {
                exam = administration.getExam(view.getExamName());
            }
                //Give error if not.
            else
            {
               view.showPopUp("Please enter a valid exam");
            }
            //initialize the view
            initView();
        }
    }

    /**
     * Method to update the Question in the exam panel
     */
    public void updateQuestion()
    {
         view.showQuestion(exam.getQuestion(questionCount).getQuestion());
         view.showAnswers(exam.getQuestion(questionCount).getAnswers());
    }
}
