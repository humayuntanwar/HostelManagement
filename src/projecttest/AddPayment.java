/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Humayun
 */
public class AddPayment extends JFrame implements ActionListener {

     JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();
    
    JTextArea b = new JTextArea(60, 100);
    
    JLabel lroom1=new JLabel("Room");
    JLabel lamount = new JLabel("Amount");
    JLabel lmonth = new JLabel("Month");
    
    JButton b6 = new JButton("Make Payment");
    JButton b7 = new JButton("List Payment");
    
     JTextField t4 = new JTextField(5);
    JTextField t5 = new JTextField(5);
    JTextField t6 = new JTextField(5);
     JTextField t7 = new JTextField(5);
     int numberOfRooms;
     AddPayment(int room){
         numberOfRooms=room;
         setLayout(new GridLayout(3,1));
         setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(520,100);
        setTitle("PAYMENT MENU");

         
        add(p4);
        add(p5);
        add(p6);
        
         p4.setLayout(new GridLayout(3, 2));
        p4.add(lroom1);
        p4.add(t5);
              
        p4.add(lmonth);
        p4.add(t6);
        p4.add(lamount);
        p4.add(t7);

        p5.setLayout(new FlowLayout());
        p5.add(b6);
        p5.add(b7);

        p6.setLayout(new FlowLayout());
        p6.add(b);
        p6.setBorder(new TitledBorder("Payments"));
        b7.addActionListener(this);
        b6.addActionListener(this);
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b6) {
            int room = Integer.parseInt(t5.getText());
            
            double amount = Double.parseDouble(t7.getText());
            Payment pay=new Payment(t6.getText(),amount,room);
            pay.checkPayment();
            pay.store();
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
            /*if (room < 1 || room > numberOfRooms) {
                b.setText("Invalid Room number!");
            } else if (t5.getText() == "" || t6.getText() == "" || t7.getText() == "") {
               b.setText("Room, month or amount cannot be blank");
            } else if (amount < 0) {
               b.setText("amount must be a positive number!");
            } */

            }
        
        if(ae.getActionCommand().equalsIgnoreCase("List Payment")){
           JFrame fm = new JFrame("Payment Record");
            JTextArea textArea;

            JScrollPane sp = new JScrollPane(textArea = new JTextArea());
		fm.setSize(300, 300);
                fm.setVisible(true);
                fm.setLocationRelativeTo(null);
                
		Scanner f = null;
		try {
			f = new Scanner(new FileInputStream("Payments.txt"));
		} catch (FileNotFoundException b) {
			JOptionPane.showMessageDialog(null, "File Not Found!");
		}
		String LINE = "", line = "";
		//fm.add(textArea);
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


