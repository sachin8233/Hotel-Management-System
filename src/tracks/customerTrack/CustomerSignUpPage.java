package tracks.customerTrack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CustomerSignUpPage extends JFrame {
    static JTextField firstNameTextField;
    static JTextField secondNameTextField;
    static JTextField emailTextField;
    static JTextField phoneNumberTextField;
    static JPasswordField passwordTextField;
    static JPasswordField confirmPasswordTextField;
    static JButton backButton;
    static JCheckBox checkBoxForPassword;
    static JLabel firstNameLabel;
    static JLabel secondNameLabel;
    static JLabel emailLabel;
    static JLabel phoneNumberLabel;
    static JLabel passwordLabel;
    static JLabel confirmPasswordLabel;
    static JButton signUpButton;

//    public static void main(String[] args) {
//        new CustomerSignUpPage();
//
//    }

    CustomerSignUpPage() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        firstNameTextField = new JTextField();
        secondNameTextField = new JTextField();
        emailTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        passwordTextField = new JPasswordField();
        confirmPasswordTextField = new JPasswordField();
        backButton = new JButton("Back");
        checkBoxForPassword = new JCheckBox("Show Password");
        firstNameLabel = setPropertiesOfJLabel("First Name");
        secondNameLabel = setPropertiesOfJLabel("Second name");
        emailLabel = setPropertiesOfJLabel("Email");
        phoneNumberLabel = setPropertiesOfJLabel("Phone Number");
        passwordLabel = setPropertiesOfJLabel("Password");
        confirmPasswordLabel = setPropertiesOfJLabel("Confirm Password");
        signUpButton =new JButton("Sign Up");

        //setting the positions of various components
        firstNameTextField.setBounds(500, 300, 200, 30);
        secondNameTextField.setBounds(900, 300, 200, 30);
        emailTextField.setBounds(500, 400, 200, 30);
        phoneNumberTextField.setBounds(900, 400, 200, 30);
        passwordTextField.setBounds(500, 500, 200, 30);
        confirmPasswordTextField.setBounds(900, 500, 200, 30);
        backButton.setBounds(0, 0, 65, 30);
        checkBoxForPassword.setBounds(1150, 507, 120, 15);
        firstNameLabel.setBounds(500, 260, 200, 30);
        secondNameLabel.setBounds(900, 260, 200, 30);
        emailLabel.setBounds(500, 360, 200, 30);
        phoneNumberLabel.setBounds(900, 360, 200, 30);
        passwordLabel.setBounds(500, 460, 200, 30);
        confirmPasswordLabel.setBounds(900, 460, 200, 30);
        signUpButton.setBounds(700,600,200,50);

        //set properties of various components
        checkBoxForPassword.setOpaque(false);
        checkBoxForPassword.setForeground(Color.WHITE);
        passwordTextField.setEchoChar('X');
        confirmPasswordTextField.setEchoChar('X');

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new CustomerMainPage();
            dispose();
        });
        checkBoxForPassword.addActionListener(e -> {
            if (checkBoxForPassword.isSelected()) {
                passwordTextField.setEchoChar((char) 0);
                confirmPasswordTextField.setEchoChar((char) 0);
            } else {
                passwordTextField.setEchoChar('X');
                confirmPasswordTextField.setEchoChar('X');
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!firstNameTextField.getText().isEmpty() && !emailTextField.getText().isEmpty() && !phoneNumberTextField.getText().isEmpty() && Arrays.toString(passwordTextField.getPassword()).equals(Arrays.toString(confirmPasswordTextField.getPassword())) && passwordTextField.getPassword()!=null){
                    JOptionPane.showMessageDialog(getContentPane(),"You are all signed up");
                    new CustomerMainPage();
                    dispose();

                }
            }
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(firstNameLabel);
        backgroundJLabel.add(secondNameLabel);
        backgroundJLabel.add(emailLabel);
        backgroundJLabel.add(phoneNumberLabel);
        backgroundJLabel.add(passwordLabel);
        backgroundJLabel.add(confirmPasswordLabel);
        backgroundJLabel.add(firstNameTextField);
        backgroundJLabel.add(secondNameTextField);
        backgroundJLabel.add(emailTextField);
        backgroundJLabel.add(phoneNumberTextField);
        backgroundJLabel.add(passwordTextField);
        backgroundJLabel.add(confirmPasswordTextField);
        backgroundJLabel.add(backButton);
        backgroundJLabel.add(checkBoxForPassword);
        backgroundJLabel.add(signUpButton);
        frame.add(backgroundJLabel);
        frame.repaint();
    }

    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.PLAIN,20));
        return label;
    }
}
