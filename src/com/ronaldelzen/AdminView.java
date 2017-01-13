package com.ronaldelzen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ronal on 1/9/2017.
 */
public class AdminView
{
    private JButton addQuestionButton;
    private JTextField newQuestion;
    private JTextField rightAnswer;
    private JTextField newExamName;
    public JTextField answer1;
    public JTextField answer2;
    public JTextField answer3;
    public JTextField answer4;
    public JComboBox<String> selectExamBox;
    private JButton addExamButton;
    private JButton getSummaryButton;
    JFrame adminFrame;
    JPanel summaryPanel;
    /**
     * Constructor
     */
    public AdminView(ActionListener addQuestionbuttonListener, ActionListener addExamListener, ActionListener getSummarybuttonListener)
    {
        //Make User Interface
        adminFrame = new JFrame("Admin Panel");
        adminFrame.setSize(1366, 768);
        adminFrame.setLayout(new GridLayout(2, 1));
        JPanel adminPanel = new JPanel(new GridLayout(9, 2));
        adminPanel.setBackground(Color.LIGHT_GRAY);
        adminFrame.add(adminPanel);
        adminFrame.setVisible(true);
        newQuestion = new javax.swing.JTextField(20);
        JLabel Label1 = new javax.swing.JLabel("New Question");
        rightAnswer = new javax.swing.JTextField(20);
        JLabel answer1Label = new javax.swing.JLabel("Answer 1");
        JLabel answer2Label = new javax.swing.JLabel("Answer 2");
        JLabel answer3Label = new javax.swing.JLabel("Answer 3");
        JLabel answer4Label = new javax.swing.JLabel("Answer 4");
        answer1 = new javax.swing.JTextField(20);
        answer2 = new javax.swing.JTextField(20);
        answer3 = new javax.swing.JTextField(20);
        answer4 = new javax.swing.JTextField(20);
        JLabel rightAnswerLabel = new javax.swing.JLabel("Right answer");
        addQuestionButton = new JButton("Add Question");
        addQuestionButton.addActionListener(addQuestionbuttonListener);
        addExamButton = new JButton("Add Exam");
        addExamButton.addActionListener(addExamListener);
        getSummaryButton = new JButton("Get Summary");
        getSummaryButton.addActionListener(getSummarybuttonListener);
        summaryPanel = new JPanel(new GridLayout(40, 1));
        selectExamBox = new JComboBox<>();
        newExamName = new JTextField(20);
        adminPanel.add(newExamName);
        adminPanel.add(addExamButton);
        adminPanel.add(selectExamBox);
        adminPanel.add(getSummaryButton);
        adminPanel.add(Label1);
        adminPanel.add(newQuestion);
        adminPanel.add(answer1Label);
        adminPanel.add(answer1);
        adminPanel.add(answer2Label);
        adminPanel.add(answer2);
        adminPanel.add(answer3Label);
        adminPanel.add(answer3);
        adminPanel.add(answer4Label);
        adminPanel.add(answer4);
        adminPanel.add(rightAnswerLabel);
        adminPanel.add(rightAnswer);
        adminPanel.add(addQuestionButton);
        adminFrame.add(summaryPanel);
    }

    /**
     * Method to get the questionButton
     * @return question button
     */
    public JButton getQuestionButton()
    {
        return addQuestionButton;
    }

    /**
     * Method to get the new question
     * @return new question
     */
    public String getNewQuestion()
    {
        return newQuestion.getText();
    }

    /**
     * Method to get the right answer
     * @return right answer
     */
    public String getRightAnswer()
    {
        return rightAnswer.getText();
    }

    /**
     * Method to get the answers in a array
     * @return answers
     */
    public String[] getAnswers()
    {
        String[] answers = new String[4];
        answers[0] = answer1.getText();
        answers[1] = answer2.getText();
        answers[2] = answer3.getText();
        answers[3] = answer4.getText();
        return answers;
    }

    /**
     * Set values in Combobox
     * @param values
     */
    public void setSelectExamBoxValues(ArrayList<String> values)
    {
        for(String s:values){
            selectExamBox.addItem(s);
        }
    }

    /**
     * Get method for addExamButton
     * @return addExamButton
     */
    public JButton getAddExamButton()
    {
        return addExamButton;
    }

    /**
     * Method to get the new exam name from textfield
     * @return new exam name
     */
    public String getNewExamName()
    {
        return newExamName.getText();
    }

    /**
     * Method to get the getSummaryButton
     */
    public JButton getGetSummaryButton()
    {
        return getSummaryButton;
    }


    /**
     * get value from selectExamBox
     * @return selected exam
     */
    public String getSelectExamBoxValue()
    {

        System.out.println(selectExamBox.getSelectedItem().toString());
        return selectExamBox.getSelectedItem().toString();
    }

    /**
     * Method to show the summary
     */
    public void showSummary(ArrayList<MultipleChoiceQuestion> questions)
    {
        for(Question question:questions)
        {
//            int percentage =
            summaryPanel.add(new JLabel(question.getQuestion() + " is answered Right by " + question.getGoodAnswered() + " students and wrong by:" + question.getBadAnswered() + " students."));

            adminFrame.revalidate();
        }

    }

    /**
     * Method to check if a valid input is given
     * @return valid input
     */
    public boolean checkValidInput() {
        if (getRightAnswer() != null && getNewQuestion() != null && getSelectExamBoxValue() != null) {
            return true;
        }
        else
        {
            return false;
        }
    }

}