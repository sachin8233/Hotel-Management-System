package tracks.employeeTrack;

import Start.FirstPage;

import javax.swing.*;
import java.awt.*;


public class EmployeeMainPage extends JFrame {
    static JTextField username;
    static JPasswordField password;
    static JButton loginButton;
    static JButton backButton;
    static JLabel user, pass;
    static JCheckBox checkBoxPassword;


//    public static void main(String[] args) {
//        new EmployeeMainPage();
//
//    }

    public EmployeeMainPage() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        username = new JTextField();
        password = new JPasswordField();
        loginButton = new JButton("Login");
        backButton = new JButton("Back");
        user = setPropertiesOfJLabel("Username");
        pass = setPropertiesOfJLabel("Password");
        checkBoxPassword = new JCheckBox("Show Password");

        //setting properties of various components
        checkBoxPassword.setOpaque(false);
        checkBoxPassword.setForeground(Color.WHITE);
        password.setEchoChar('X');

        //setting the positions of various components
        username.setBounds(550, 200, 200, 30);
        password.setBounds(810, 200, 200, 30);
        loginButton.setBounds(680, 400, 200, 50);
        backButton.setBounds(0, 0, 80, 30);
        user.setBounds(550, 160, 200, 30);
        pass.setBounds(810, 160, 200, 30);
        checkBoxPassword.setBounds(1100, 200, 150, 15);

        //defining the actions of various buttons
        checkBoxPassword.addActionListener(e -> {
            if (checkBoxPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('X');
            }
        });
        loginButton.addActionListener(e -> {
            new OptionsForEmployee();
            frame.dispose();
        });
        backButton.addActionListener(e -> {
            new FirstPage();
            dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(username);
        backgroundJLabel.add(password);
        backgroundJLabel.add(loginButton);
        backgroundJLabel.add(backButton);
        backgroundJLabel.add(user);
        backgroundJLabel.add(pass);
        backgroundJLabel.add(checkBoxPassword);
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


