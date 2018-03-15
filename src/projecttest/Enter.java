package projecttest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Humayun
*/
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.TitledBorder;


class Enter extends JFrame implements ActionListener
{
    JPasswordField password;
    JLabel text;
    JButton b1 = new JButton("Change Password");
    public Enter()
    {
        setTitle("WELCOME TO HOSTEL MANAGEMENT");
        String a;
        a = "12345";
        setSize(500,150);
        setResizable(true);
        setVisible(true);
        setLocation(520,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
       
    
        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.LIGHT_GRAY);
        JPanel textfield = new JPanel();
        textfield.setBackground(Color.LIGHT_GRAY);
        buttonpanel.add(b1);
        
        text = new JLabel("Please Enter correct password.");
        
        buttonpanel.setLayout(new FlowLayout());
        textfield.setLayout(new FlowLayout());
        
        password = new JPasswordField("", 30);
        password.setBackground(Color.WHITE);
        
        JButton enter = new JButton("ENTER");
        JButton exit = new JButton("EXIT");
        
        enter.addActionListener(this);
        exit.addActionListener(this);
        b1.addActionListener(this);
        buttonpanel.add(enter);
        buttonpanel.add(exit);
        textfield.add(text);
        textfield.add(password);
        
        add(textfield);
        add(buttonpanel);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equalsIgnoreCase("enter"))
        {
            if(password.getText().equals(""))
            {
               //new HostelGUI(100);
                new MainFrame();
                dispose();
            }
            else
            {
                dispose();
                new Enter();                
                JOptionPane.showMessageDialog(this, "Wrong Password! Try Again.");
            }
        }
        if(ae.getActionCommand().equalsIgnoreCase("exit"))
        {
            System.exit(0);
        }
            if(ae.getActionCommand().equalsIgnoreCase("Change Password")){
               {
                   JFrame jf = new JFrame();
                   jf.setVisible(true);
                   jf.setLocationRelativeTo(null);
                   jf.setSize(400,300);
                   JTextField oldpasstxt = new JTextField();
        oldpasstxt.setBorder(new TitledBorder("old pass"));
                   JTextField npasstxt = new JTextField();
                           oldpasstxt.setBorder(new TitledBorder("new pass"));

                   JTextField repasstxt = new JTextField();
                           oldpasstxt.setBorder(new TitledBorder("re new pass"));
                           jf.add(oldpasstxt);
                           jf.add(npasstxt);
                           jf.add(repasstxt);




               /* int x = 0;
                //String cuser1 = usernametxt.getText();
                String old = oldpasstxt.getText();
                String npassword = npasstxt.getText();
                String repassword = repasstxt.getText();
                try
                {
                    Connection con=null;
                    con = CreateConnection.connectMe();
                    //if(cuser1.equals("") || old.equals("") || npassword.equals("") || repassword.equals(""))
                    {
                            JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL INFORMATION");
                    }
                    else
                    {
                        if(vali(cuser1,old))
                        {
                            if(npassword.equals(old))
                            {
                                JOptionPane.showMessageDialog(null, "PASSWORD IS ALL REDY EXIST PLEASE CHOOSE OTHER PASSWORD");
                            }
                            else
                            {
                                if(npassword.equals(repassword))
                                {
                                    con = CreateConnection.connectMe();
                                    PreparedStatement st;
                                    st = con.prepareStatement("UPDATE createaccount SET password = ? where cuser = ?");
                                    st.setString(1, npassword);
                                    st.setString(2, cuser1);
                                    st.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "PASSWORD UPDATE SUCCESSFUL");
                                    repasstxt.setText(null);
                                    npasstxt.setText(null);
                                    usernametxt.setText(null);
                                    oldpasstxt.setText(null);
                                    setVisible(false);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "PASSWORD NOT MATCH");
                                    repasstxt.setText(null);
                                    npasstxt.setText(null);
                                }
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "USERNAME NOT FOUND");
                            repasstxt.setText(null);
                            npasstxt.setText(null);
                            usernametxt.setText(null);
                            oldpasstxt.setText(null);
                        }
                    }
                }
                catch(ClassNotFoundException e) 
                {
                    JOptionPane.showMessageDialog(null, "Connection class is not found");
                }
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "Query Not Executed");
                }
                catch (IOException e) 
                {
                    JOptionPane.showMessageDialog(null, "Input/Output Error");
                }
            } */          


        }

    }
        
    
}}
