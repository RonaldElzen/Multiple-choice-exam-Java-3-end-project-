package com.ronaldelzen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ronal on 1/10/2017.
 */
public class AdminController
{
    private Administration administration;
    private AdminView view;

    /**
     * Constructor for AdminController
     * @param administration
     */
    public AdminController(Administration administration)
    {

        this.administration = administration;
        initView();
    }

    /**
     * Method to show a summary of taken exams
     */
    public void showSummary()
    {
        
    }

    /**
     * Method to add handlers to view
     */
    public void initView() {
        //New ActionListener for add question button
        ActionListener addQuestionButtonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    //Must be handled in controller
                if(view.checkValidInput())
                {
                    String newQuestion = view.getNewQuestion();
                    int rightAnswer = Integer.parseInt(view.getRightAnswer());
                    String[] answers = view.getAnswers();
                    MultipleChoiceQuestion question = new MultipleChoiceQuestion(newQuestion, answers, rightAnswer);
                    administration.getExam(view.getSelectExamBoxValue()).addQuestion(question);
                }
            }
        };


        //New actionListener for AddExamButton
        ActionListener addExamListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    administration.addExam(view.getNewExamName());
                    view.setSelectExamBoxValues(administration.getAvailableExamNames());
            }
        };

        //New actionListener for getSummaryButton
        ActionListener getSummaryButtonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getSelectExamBoxValue() != null)
                {
                    MultipleChoiceExam exam  = administration.getExam(view.getSelectExamBoxValue());
                    view.showSummary(exam.getQuestions());



                }
            }
        };

        view = new AdminView(addQuestionButtonListener,addExamListener,getSummaryButtonListener);

        if (administration.getAvailableExamNames() != null)
        {
            //Place values in ComboBox
            view.setSelectExamBoxValues(administration.getAvailableExamNames());

        }
    }
}
