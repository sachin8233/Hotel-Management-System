package tracks.customerTrack.options;

import tracks.customerTrack.OptionsForCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSupport extends JFrame {
    static JLabel PhoneNumber;
    static JLabel ReceptionLabel;
    static JLabel NumberLabel;
    static JLabel ReceptionNumber;
    static JLabel ManagerLabel;
    static JLabel ManagerNumber;
    static JLabel HouseKeepingLabel;
    static JLabel HouseKeepingNumber;
    static JLabel RestaurantLabel;
    static JLabel RestaurantNumber;
    static JButton backButton;

//    public static void main(String[] args) {
//        new CustomerSupport();
//
//    }

    public CustomerSupport() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        PhoneNumber = setPropertiesOfJLabelBig("Department");
        NumberLabel = setPropertiesOfJLabelBig("Contact Number");
        ManagerLabel = setPropertiesOfJLabel("Manager");
        ManagerNumber = setPropertiesOfJLabel("123456");
        HouseKeepingLabel = setPropertiesOfJLabel("House Keeping");
        HouseKeepingNumber = setPropertiesOfJLabel("3456789");
        RestaurantLabel = setPropertiesOfJLabel("Restaurant");
        RestaurantNumber = setPropertiesOfJLabel("45647890");
        backButton = new JButton("back");
        ReceptionLabel= setPropertiesOfJLabel("Reception");
        ReceptionNumber=setPropertiesOfJLabel("23456789");

        //setting the positions of various components
        PhoneNumber.setBounds(450, 100, 400, 50);
        NumberLabel.setBounds(750, 100, 400, 50);
        ManagerLabel.setBounds(500, 200, 400, 50);
        ManagerNumber.setBounds(800, 200, 400, 50);
        HouseKeepingLabel.setBounds(500, 280, 400, 50);
        HouseKeepingNumber.setBounds(800, 280, 400, 50);
        RestaurantLabel.setBounds(500, 360, 400, 50);
        RestaurantNumber.setBounds(800, 360, 400, 50);
        backButton.setBounds(0, 0, 80, 30);
        ReceptionLabel.setBounds(500,440,400,50);
        ReceptionNumber.setBounds(800,440,400,50);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new OptionsForCustomer();
            frame.dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(PhoneNumber);
        backgroundJLabel.add(NumberLabel);
        backgroundJLabel.add(ManagerLabel);
        backgroundJLabel.add(ManagerNumber);
        backgroundJLabel.add(HouseKeepingLabel);
        backgroundJLabel.add(HouseKeepingNumber);
        backgroundJLabel.add(RestaurantLabel);
        backgroundJLabel.add(RestaurantNumber);
        backgroundJLabel.add(backButton);
        backgroundJLabel.add(ReceptionLabel);
        backgroundJLabel.add(ReceptionNumber);
        frame.add(backgroundJLabel);
        frame.repaint();
    }

    //A customized JLabel
    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
    //A customized JLabel with bigger fort
    private static JLabel setPropertiesOfJLabelBig(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        return label;
    }
}
