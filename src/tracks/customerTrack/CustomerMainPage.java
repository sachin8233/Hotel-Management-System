package tracks.customerTrack;

import Start.FirstPage;
import javax.swing.*;
import java.awt.*;

public class CustomerMainPage extends JFrame {
//    public static void main(String[] args) {
//        new CustomerMainPage();
//    }

    static JTextField username;
    static JPasswordField password;
    static JButton loginButton;
    static JButton signupButton;
    static JButton backButton;
    static JCheckBox checkBoxPassword;

    public CustomerMainPage() {
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
        signupButton = new JButton("New to our Hotel? SignUp");
        backButton = new JButton("Back");
        checkBoxPassword = new JCheckBox("show password");

        //set properties of various components
        checkBoxPassword.setOpaque(false);
        checkBoxPassword.setForeground(Color.WHITE);
        password.setEchoChar('X');

        //setting the positions of various components
        username.setBounds(550, 200, 200, 30);
        password.setBounds(810, 200, 200, 30);
        loginButton.setBounds(680, 400, 200, 50);
        signupButton.setBounds(680, 550, 200, 50);
        backButton.setBounds(0, 0, 65, 30);
        checkBoxPassword.setBounds(810, 250, 120, 15);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new FirstPage();
            dispose();
        });
        checkBoxPassword.addActionListener(e -> {
            if (checkBoxPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('X');
            }
        });
        signupButton.addActionListener(e -> {
            new CustomerSignUpPage();
            dispose();
        });
        loginButton.addActionListener(e -> {
            new OptionsForCustomer();
            dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(username);
        backgroundJLabel.add(password);
        backgroundJLabel.add(loginButton);
        backgroundJLabel.add(signupButton);
        backgroundJLabel.add(backButton);
        backgroundJLabel.add(checkBoxPassword);
        frame.add(backgroundJLabel);
        frame.repaint();
    }

}
