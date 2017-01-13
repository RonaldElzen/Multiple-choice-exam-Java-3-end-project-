package com.ronaldelzen;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ronal on 1/6/2017.
 */
public class Administration
{
    private MultipleChoiceExam exam;
    public ArrayList<TakenExam> takenExams;
    public HashMap<String, MultipleChoiceExam> availableExams;


    /**
     * Constructor for Administration
     */
    public Administration() {
        takenExams = new ArrayList<>();
        availableExams = new HashMap<>();
        exam = new MultipleChoiceExam();
    }

    public ArrayList<String> getAvailableExamNames()
    {
        ArrayList<String> names = new ArrayList<>();
        Iterator it = availableExams.entrySet().iterator();
    while (it.hasNext())
    {
        Map.Entry pair = (Map.Entry)it.next();
        names.add(pair.getKey().toString());
    }
     return names;
    }

    /**
     * Method to add a taken exam
     * @param student
     * @param answers
     */
    public void addTakenExam(Student student, ArrayList<String> answers, MultipleChoiceExam exam) {
        takenExams.add(new TakenExam(exam,student,answers));
    }


    /**
     * Method to get a exam
     * @return
     */
    public MultipleChoiceExam getExam(String name) {
        return availableExams.get(name);
    }


    /**
     * Method to calculate the grade
     * @param takenExam
     * @param exam
     * @return grade
     */
    public double calculateGrade(ArrayList<String> takenExam, MultipleChoiceExam exam) {

        int score = 0;
        double grade = 0.0;

        //Loop through exam and compare the answers given by student
        for (int i = 0; i < exam.getNumberOfQuestions(); i++) {
            if (takenExam.get(i).equals(exam.getQuestion(i).getRightAnswer())) {
                //Increase right answers
                score++;

                //Calculate grade
                //First 10 points have less score because of the random change
                if (score <= 10) {
                    grade = grade + 1;
                }
                if (score > 10) {
                    grade = grade + 3;
                }
            }
        }
        //Return grade
        return grade / 10;
    }

    /**
     * Return a array with checked answers
     * @param takenExam
     * @param exam
     * @return checked answers
     */
    public ArrayList<String> getCheckedAnswers(ArrayList<String> takenExam, MultipleChoiceExam exam)
    {
        ArrayList<String> checked = new ArrayList<>();
        //Make an array with good and bad answered by student
        for (int i = 0; i < exam.getNumberOfQuestions(); i++) {
            if (takenExam.get(i).equals(exam.getQuestion(i).getRightAnswer())) {
                checked.add("Good answer");
                exam.getQuestion(i).addGoodAnswered();
            } else {
                checked.add("X");
                exam.getQuestion(i).addBadAnswered();
            }
        }
        return checked;
    }

    /**
     * method to check if a student has passed the exam
     * @param grade
     * @return
     */
    public boolean isPassed(double grade) {
        if (grade > 5.5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to add a new exam
     * @param name
     */
    public void addExam(String name)
    {
        availableExams.put(name,new MultipleChoiceExam());
    }
}