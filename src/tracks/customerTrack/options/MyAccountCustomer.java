package tracks.customerTrack.options;

import tracks.customerTrack.OptionsForCustomer;
import javax.swing.*;
import java.awt.*;

public class MyAccountCustomer extends JFrame {
    static JLabel nameLabel;
    static JLabel displayNameLabel;
    static JLabel phoneLabel;
    static JLabel displayPhoneLabel;
    static JLabel emailLabel;
    static JLabel displayEmailLabel;
    static JLabel membershipLabel;
    static JLabel displayMembershipLabel;
    static JButton backButton;

//    public static void main(String[] args) {
//        new MyAccountCustomer();
//
//    }

    public MyAccountCustomer() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        nameLabel = setPropertiesOfJLabel("Name");
        displayNameLabel = setPropertiesOfJLabel("Dummy Label");
        phoneLabel = setPropertiesOfJLabel("Phone");
        displayPhoneLabel = setPropertiesOfJLabel("Dummy Phone");
        emailLabel = setPropertiesOfJLabel("Email");
        displayEmailLabel =setPropertiesOfJLabel("dummy@dummy.com");
        membershipLabel = setPropertiesOfJLabel("Membership");
        displayMembershipLabel = setPropertiesOfJLabel("Dummy Level");
        backButton = new JButton("back");

        //setting the positions of various components
        int posX1 = 500, posX2 = 870;
        nameLabel.setBounds(posX1, 300, 200, 20);
        displayNameLabel.setBounds(posX2, 300, 400, 50);
        phoneLabel.setBounds(posX1, 400, 200, 50);
        displayPhoneLabel.setBounds(posX2, 400, 400, 50);
        emailLabel.setBounds(posX1, 500, 200, 50);
        displayEmailLabel.setBounds(posX2, 500, 400, 50);
        membershipLabel.setBounds(posX1, 600, 200, 50);
        displayMembershipLabel.setBounds(posX2, 600, 200, 50);
        backButton.setBounds(0, 0, 80, 30);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new OptionsForCustomer();
            frame.dispose();
        });
        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        frame.add(backgroundJLabel);
        backgroundJLabel.add(nameLabel);
        backgroundJLabel.add(displayNameLabel);
        backgroundJLabel.add(phoneLabel);
        backgroundJLabel.add(displayPhoneLabel);
        backgroundJLabel.add(emailLabel);
        backgroundJLabel.add(displayEmailLabel);
        backgroundJLabel.add(membershipLabel);
        backgroundJLabel.add(displayMembershipLabel);
        backgroundJLabel.add(backButton);
        frame.repaint();
    }
    // A customized JLabel
    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.PLAIN,30));
        return label;
    }
}
