package tracks.employeeTrack;

import tracks.employeeTrack.optionsForEmployee.AttendanceForEmployee;
import tracks.employeeTrack.optionsForEmployee.MessageHR;
import tracks.employeeTrack.optionsForEmployee.MyDetails;

import javax.swing.*;

public class OptionsForEmployee extends JFrame {
    static JButton detailsButton, attendanceButton, messageToHRButton;
    static JButton backButton;

//    public static void main(String[] args) {
//        new OptionsForEmployee();
//
//    }

    public OptionsForEmployee() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        detailsButton = new JButton("My Details");
        attendanceButton = new JButton("Attendance");
        messageToHRButton = new JButton("Message H.R.");
        backButton = new JButton("back");

        //setting the positions of various components
        detailsButton.setBounds(660, 300, 300, 50);
        attendanceButton.setBounds(660, 400, 300, 50);
        messageToHRButton.setBounds(660, 500, 300, 50);
        backButton.setBounds(0, 0, 80, 30);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new EmployeeMainPage();
            frame.dispose();
        });
        detailsButton.addActionListener(e -> {
            new MyDetails();
            dispose();
        });
        attendanceButton.addActionListener(e -> {
            new AttendanceForEmployee();
            dispose();
        });
        messageToHRButton.addActionListener(e -> new MessageHR());

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(detailsButton);
        backgroundJLabel.add(attendanceButton);
        backgroundJLabel.add(messageToHRButton);
        backgroundJLabel.add(backButton);
        frame.add(backgroundJLabel);
        frame.repaint();
    }
}
