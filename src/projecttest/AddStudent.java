/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Humayun
 */
public class AddStudent extends JFrame implements ActionListener {
    JFrame nw;
    JTextField name2;
    
    JButton loginAsSearch,back;
    JFrame j = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JTextArea students;

    JLabel lname = new JLabel("Name");
    JLabel lroom = new JLabel("Room");
    JLabel ldob = new JLabel("University ");

    JButton addStudent = new JButton("Add Student");
    JButton b2 = new JButton("Display Student");
    JButton b3 = new JButton("Search");
    JButton b4 = new JButton("Save And Quit");
    JButton b5 = new JButton("Quit without Saving");
    JButton b6 = new JButton("Main Menu");

    JTextField t1 = new JTextField(5);
    JTextField t2 = new JTextField(5);
    JTextField t3 = new JTextField(5);
    private int numberOfrooms;

    AddStudent(int rooms) {
        students = new JTextArea();
        students.setBounds(0, 200, 40, 80);
        students.setEditable(false);


        //numberOfrooms = room;
        j.setLayout(new GridLayout(4, 1));
        j.setVisible(true);
        j.setSize(500, 600);
        // setBounds(700,200,800,800);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        j.setTitle("STUDENT MENU");


        add(p1);
        add(p2);
        add(p3);
        p1.setLayout(new GridLayout(3, 2));

        p1.add(lname);
        p1.add(t1);
        p1.add(lroom);
        p1.add(t2);
        p1.add(ldob);
        p1.add(t3);
        pack();
        p2.setLayout(new FlowLayout());

        p2.add(addStudent);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        pack();
        j.add(p1);
        j.add(p2);
        j.add(students);
        students.setBorder(new TitledBorder("Student"));
        addStudent.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        pack();

    }
    

    private void enterName() {
        nw = new JFrame("Quick Access");
        nw.setSize(400, 150);
        //nw.setBounds(500, 280, 345, 130);
        nw.setLayout(new GridLayout(1, 3));

        JPanel pnl = new JPanel();
        pnl.add(new JLabel("	Name        "));

        name2 = new JTextField(18);
        pnl.add(name2);

       

        loginAsSearch = new JButton("Find");
        loginAsSearch.addActionListener(this);
        pnl.add(loginAsSearch);

        back = new JButton("Cancel");
        back.addActionListener(this);
        pnl.add(back);

        nw.add(pnl);
        nw.setVisible(true);
    }

    private void Search() {

        JFrame srch = new JFrame("Searching As an Administrator");
        srch.setSize(600, 500);

        Scanner f = null;
        try {
            f = new Scanner(new FileInputStream("StudentRecord.txt"));
        } catch (FileNotFoundException b) {
            JOptionPane.showMessageDialog(null, "File Not Found!");
        }

        String LINE = "", line = "", LINE1 = "";

        JTextArea textArea = new JTextArea(20, 20);
        srch.add(textArea);

        while (f.hasNext()) {
            String name12;
            name12 = f.nextLine();
           
	 if (name2.getText().equals(name12) ) {
                line = name12;
                LINE += " " + line + "\n";
                line = f.nextLine();
                LINE += " " + line + "\n";
                line = f.nextLine();
                LINE += " " + line + "\n";
                line = f.nextLine();
                

            } else {

                f.nextLine();
                f.nextLine();
                f.nextLine();
                
            }
        }

        textArea.setText(LINE1);
        if (LINE1.equals("")) {

            JOptionPane.showMessageDialog(null, "No Data Found");
        }
        srch.setVisible(true);
        f.close();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addStudent) {
            
            Student stdnt = new Student(t1.getText(), Integer.parseInt(t2.getText()), t3.getText());
            students.append("Mr " + t1.getText() + " From University of " + t3.getText() + " has been added to Room no : " + t2.getText());
            stdnt.store();
            t1.setText("");
            t2.setText("");
            t3.setText(null);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
        if (ae.getActionCommand().equalsIgnoreCase("Main Menu")) {
            new MainFrame();
            j.dispose();
        }
        if (ae.getSource() == b4) {
            Student stdnt = new Student(t1.getText(), Integer.parseInt(t2.getText()), t3.getText());
            stdnt.store();
            System.exit(0);
        }
        if (ae.getSource() == b5) {
            System.exit(0);
        }
        if (ae.getSource() == b3) {
            enterName();
        }if (ae.getSource()==loginAsSearch) {
            Search();}

        if (ae.getActionCommand().equalsIgnoreCase("Display Student")) {
            JFrame fm = new JFrame("Student Records");
            JTextArea textArea;

            JScrollPane sp = new JScrollPane(textArea = new JTextArea());
            

            fm.setSize(300, 600);
            fm.setVisible(true);
            fm.setLocationRelativeTo(null);

            Scanner f = null;
            try {
                f = new Scanner(new FileInputStream("StudentRecord.txt"));
            } catch (FileNotFoundException b) {
                JOptionPane.showMessageDialog(null, "File Not Found!");
            }
            String LINE = "", line = "";
            fm.add(sp);
            while (f.hasNext()) {

                line = f.nextLine();
                LINE += " " + line + "\n";

            }

            textArea.setText(LINE);
            fm.setVisible(true);
            f.close();

        }
    }
}
