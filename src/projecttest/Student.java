/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

//import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Humayun
 */
public class Student {

    public File file;
    private String name;
    private int room;
    private String university;

    public Student(String nameIn, int roomIn, String uni) {
        if
            (roomIn > 100 || roomIn < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Room No Entered");
        } else {
            name = nameIn;
            room = roomIn;
            university = uni;
        }
    }

    public String getName() {
        return name;
    }

    public int getRoom() {
        return room;
    }

    public String getUniversity() {
        return university;
    }

   

    public String toString() {
        return name + ", " + room;
    }

    public void store() {
        //file = new File("StudentRecord.txt");
        PrintWriter rw = null;
        System.out.println("yes");
        try {
            System.out.println("yes");
            rw = new PrintWriter(new FileOutputStream("StudentRecord.txt", true));
            System.out.println("tes");
            rw.println(name);
            rw.println(room);
            rw.println(university);
            rw.println("---------------------------------------------------");
            rw.close();
        } catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
