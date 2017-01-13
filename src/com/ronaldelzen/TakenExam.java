package com.ronaldelzen;

import java.util.ArrayList;

/**
 * Created by ronal on 1/12/2017.
 */
public class TakenExam
{
  MultipleChoiceExam exam;
    Student student;
    ArrayList<String> answers;

    public TakenExam(MultipleChoiceExam exam, Student student, ArrayList<String> answers)
    {
        this.exam = exam;
        this.student = student;
        this.answers = answers;
    }

    public MultipleChoiceExam getExam() {
        return exam;
    }

    public void setExam(MultipleChoiceExam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}
