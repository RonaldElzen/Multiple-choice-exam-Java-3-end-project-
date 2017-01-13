package com.ronaldelzen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ronal on 1/9/2017.
 */
public class ExamView {

    private JLabel questionLabel;
    private JComboBox<String> answerInput;
    private JButton submitButton;
    private JPanel questionPanel;
    private JPanel answerPanel;
    private String examName;
    private JFrame examFrame;
    JPanel gradePanel;

    public ExamView(ActionListener submitListener) {
        questionLabel = new JLabel();
        examFrame = new JFrame("Exam Panel");
        examFrame.setSize(1366, 768);
        examFrame.setLayout(new GridLayout(2, 2));
        questionPanel = new JPanel(new GridLayout(1, 1));
        answerPanel = new JPanel(new GridLayout(2, 2));
        answerPanel.setBackground(Color.LIGHT_GRAY);
        examFrame.add(questionPanel);
        examFrame.add(answerPanel);
        examFrame.setVisible(true);
        answerInput = new JComboBox<>();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(submitListener);
        answerPanel.add(answerInput);
        answerPanel.add(submitButton);
        questionPanel.add(questionLabel);
        gradePanel = new JPanel(new GridLayout(20, 20));
        examFrame.add(gradePanel);
    }

    public void selectExamPopUp(ArrayList<String> values) {
        JFrame popUpFrame = new JFrame("Select Exam");
        examName = JOptionPane.showInputDialog(popUpFrame, "Select Exam");
    }

    public void showPopUp(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public void showAnswers(String[] answers) {
        answerInput.removeAllItems();
        for (int i = 0; i < answers.length; i++) {
            answerInput.addItem(answers[i]);
        }
    }

    public String getExamName() {
        return examName;
    }

    public JLabel getQuestionLabel() {
        return questionLabel;
    }

    public void showQuestion(String text) {
        questionLabel.setText(text);

    }

    public void showGradePanel(double grade, ArrayList<String> checkedAnswers) {
        JOptionPane.showMessageDialog(null, grade);

        for (int i = 0; i < checkedAnswers.size(); i++) {
            JLabel label = new JLabel("Question " + i + " " + checkedAnswers.get(i).toString());

            gradePanel.add(label);
        }

        examFrame.revalidate();
    }

    public void showGrade(double grade, boolean isPassed) {
        if (isPassed)

        {
            JOptionPane.showMessageDialog(null, "Your grade is: " + grade + " You have passed the exam!");
        } else {
            JOptionPane.showMessageDialog(null, "Your grade is: " + grade + " You have failed the exam!");
        }
    }

    public String getGivenAnswer() {
        return answerInput.getSelectedItem().toString();
    }
}