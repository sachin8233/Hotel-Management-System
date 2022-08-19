package Start;

import tracks.customerTrack.CustomerMainPage;
import tracks.employeeTrack.EmployeeMainPage;
import javax.swing.*;
import java.awt.*;

public class FirstPage extends JFrame {
    static JButton forCustomer;
    static JButton forEmployee;
    static JLabel welcomeLabel;

    public static void main(String[] args) {
        new FirstPage();
    }
    public FirstPage() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        forCustomer = new JButton("I am a Customer");
        forEmployee = new JButton("I am an Employee");
        welcomeLabel = new JLabel("Welcome to Mariot");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        welcomeLabel.setForeground(Color.WHITE);

        //defining the actions of various buttons
        forCustomer.addActionListener(e -> {
            new CustomerMainPage();
            dispose();
        });

        forEmployee.addActionListener(e -> {
            new EmployeeMainPage();
            dispose();
        });

        //setting the positions of various components
        forEmployee.setBounds(1000, 700, 300, 50);
        forCustomer.setBounds(200, 700, 300, 50);
        welcomeLabel.setBounds(500, 0, 700, 200);

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        frame.add(backgroundJLabel);
        backgroundJLabel.add(welcomeLabel);
        backgroundJLabel.add(forCustomer);
        backgroundJLabel.add(forEmployee);
        frame.repaint();
    }
}
