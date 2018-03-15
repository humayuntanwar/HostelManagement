/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Humayun
 */
public class Payment {
    File file;
    private int room;
    private String month;
    private double amount;
    private double debt;

    public Payment(String monthIn, double amountIn,int room) {
        month = monthIn;
        amount = amountIn;
        this.room=room;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return month + ", " + amount;
    }
    public void checkPayment(){
        if(amount<9000){
            debt=9000-amount;
        JOptionPane.showMessageDialog(null,"You have "+debt+" Remaining");}
        else {
                JOptionPane.showMessageDialog(null, "Your Payment is full,Thank you") ;               }
    }
    public void store(){
        file=new File("Payments.txt");
        try {
            PrintWriter rw=new PrintWriter(new FileWriter(file,true));
            rw.println("Room No. :"+room);
            rw.println("Month :"+month);
            rw.println("Payment Amount :"+amount);
            rw.println("Remaining Payment :"+debt);
            rw.println("---------------------------------------------------");
            rw.close();
        } catch (IOException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void view() {
		JFrame fm = new JFrame("Payments");
		fm.setSize(300, 600);
		Scanner f = null;
		try {
			f = new Scanner(new FileInputStream("Payment.txt"));
		} catch (FileNotFoundException b) {
			JOptionPane.showMessageDialog(null, "File Not Found!");
		}
		String LINE = "", line = "";
		JTextArea textArea = new JTextArea();
		fm.add(textArea);
}
}
