/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Humayun
 */
public class MainFrame extends JFrame implements ActionListener {

    JPanel p1 = new JPanel();
    JButton b1 = new JButton("Add Student");
    JButton b2 = new JButton("Add Payment");
    JTextArea text = new JTextArea("               Welcome To Hostel \n We offer one Room with monthly Payment 9000");
    JPanel p2 = new JPanel();
    JLabel img = new JLabel(new ImageIcon("hms.jpg"));
    //private MessagePanel a;

    MainFrame() {
        setLayout(new GridLayout(2, 1));
        setTitle("WELCOME TO MAIN MENU");
        text.setEditable(false);
        text.setBackground(Color.white);
        setVisible(true);
        setSize(400, 300);
        setLocation(520, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // img.setBounds(80,70,400,500);
        // p1.setBounds(0,100,10,30);
        //setLayout(new BorderLayout());
        add(p1);
        add(p2);
        p1.add(text, BorderLayout.CENTER);
        p2.add(b1, BorderLayout.EAST);
        p2.add(b2, BorderLayout.WEST);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equalsIgnoreCase("Add Student")) {
            new AddStudent(100);
            dispose();
        }
        if (ae.getActionCommand().equalsIgnoreCase("Add Payment")) {
            new AddPayment(100);
            dispose();
        }
    }

}
