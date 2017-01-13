package com.ronaldelzen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    private Administration administration;
    private Student student;


    public static void main(String[] args)
    {
     Administration administration = new Administration();
     Student student = new Student("Ronald",1);

        JFrame   frame = new JFrame("Home");
        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(400, 400);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JPanel panel = new JPanel(new FlowLayout());
        JButton studentButton = new JButton("Student");
        JButton teacherButton = new JButton("Teacher");
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController adminController = new AdminController(administration);
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             ExamController examController = new ExamController(student,administration);
            }
        });

        panel.add(studentButton);
        panel.add(teacherButton);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
