/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

/**
 *
 * @author Humayun
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SplashScreen extends JWindow
{

private static JProgressBar progressBar = new JProgressBar();
private static SplashScreen execute;
private static int count;   
private static Timer timer1;

public SplashScreen()
{                   
    Container container = getContentPane();
    container.setLayout(null);      

    JPanel panel = new JPanel();
    panel.setBorder(new javax.swing.border.EtchedBorder());
    panel.setBackground(new Color(255,255,255));
    panel.setBounds(10,10,348,150);
    panel.setLayout(null);
    container.add(panel);       

    JLabel label = new JLabel(new ImageIcon());
    //label.setFont(new Font("Verdana",Font.BOLD,14));
    label.setIcon(new ImageIcon("C:\\Users\\humayuun\\Downloads\\112.jpg"));
   // label.setBounds(85,25,280,30);
    panel.add(label);
    

    progressBar.setMaximum(50);
    progressBar.setBounds(55, 180, 250, 15);        
    container.add(progressBar);         
    loadProgressBar();                  
    setSize(370,215);
    setLocationRelativeTo(null);
    setVisible(true);
   
}
public void loadProgressBar()
{
    ActionListener al = new ActionListener()
    {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
            count++;
            progressBar.setValue(count);
            if (count == 50){
                timer1.stop();
                execute.setVisible(false);
                new Enter();

                            //load the rest of your application

            }               
        }};         
    timer1 = new Timer(30, al);
    timer1.start();
}

public static void main (String args[]){    
     execute = new SplashScreen();
     
   }
}