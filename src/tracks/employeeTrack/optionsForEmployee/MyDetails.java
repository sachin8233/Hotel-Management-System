package tracks.employeeTrack.optionsForEmployee;

import tracks.employeeTrack.OptionsForEmployee;

import javax.swing.*;
import java.awt.*;

public class MyDetails extends JFrame {
    static JLabel name,displayName;
    static JLabel phone, displayPhone;
    static JLabel email, displayEmail;
    static JLabel salary, displaySalary;
    static JLabel position, displayPosition;
    static JButton backButton;
//    public static void main(String[] args) {
//        new MyDetails();
//    }
    public MyDetails(){
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        phone=setPropertiesOfJLabel("Phone Number");
        name=setPropertiesOfJLabel("Name");
        email=setPropertiesOfJLabel("My email address");
        salary=setPropertiesOfJLabel("My salary");
        position=setPropertiesOfJLabel("My Position");
        displayName=setPropertiesOfJLabel("Dummy name");
        displayEmail=setPropertiesOfJLabel("Dummy Email");
        displayPhone=setPropertiesOfJLabel("Dummy number");
        displaySalary=setPropertiesOfJLabel("Dummy Salary");
        displayPosition=setPropertiesOfJLabel("Dummy Position");
        backButton=new JButton("Back");

        //setting the positions of various components
        name.setBounds(500,200,300,50);
        phone.setBounds(500,300,300,50);
        email.setBounds(500,400,300,50);
        salary.setBounds(500,500,300,50);
        position.setBounds(500,600,300,50);
        displayName.setBounds(800,200,300,50);
        displayPhone.setBounds(800,300,300,50);
        displayEmail.setBounds(800,400,300,50);
        displaySalary.setBounds(800,500,300,50);
        displayPosition.setBounds(800,600,300,50);
        backButton.setBounds(0,0,80,30);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new OptionsForEmployee();
            dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(name);
        backgroundJLabel.add(phone);
        backgroundJLabel.add(email);
        backgroundJLabel.add(salary);
        backgroundJLabel.add(position);
        backgroundJLabel.add(displayName);
        backgroundJLabel.add(displayPhone);
        backgroundJLabel.add(displayEmail);
        backgroundJLabel.add(displaySalary);
        backgroundJLabel.add(displayPosition);
        backgroundJLabel.add(backButton);
        frame.add(backgroundJLabel);
        frame.repaint();
    }
    //a customized JLabel
    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
}
