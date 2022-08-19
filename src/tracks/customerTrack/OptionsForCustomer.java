package tracks.customerTrack;

import tracks.customerTrack.options.*;
import javax.swing.*;


public class OptionsForCustomer extends JFrame {
    static JButton myBookings;
    static JButton bookRooms;
    static JButton customerSupport;
    static JButton feedBack;
    static JButton myAccount;
    static JButton backButton;
    //    public static void main(String[] args) {
//        new OptionsForCustomer();
//    }

    public OptionsForCustomer() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        myBookings = new JButton("My Bookings");
        bookRooms = new JButton("Book Room");
        customerSupport = new JButton("Support And Services");
        feedBack = new JButton("Provide Feedback");
        myAccount = new JButton("My Account");
        backButton = new JButton("Back");

        //setting the positions of various components
        myAccount.setBounds(500, 300, 180, 50);
        myBookings.setBounds(870, 300, 180, 50);
        bookRooms.setBounds(500, 400, 550, 50);
        feedBack.setBounds(500, 500, 180, 50);
        customerSupport.setBounds(870, 500, 180, 50);
        backButton.setBounds(0, 0, 80, 30);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new CustomerMainPage();
            dispose();
        });
        myAccount.addActionListener(e -> {
            new MyAccountCustomer();
            frame.dispose();
        });
        feedBack.addActionListener(e -> new FeedBack());
        customerSupport.addActionListener(e -> {
            new CustomerSupport();
            dispose();
        });
        bookRooms.addActionListener(e -> {
            new RoomBooking();
            dispose();
        });
        myBookings.addActionListener(e -> {
            new MyBookingsPage();
            dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(myAccount);
        backgroundJLabel.add(myBookings);
        backgroundJLabel.add(bookRooms);
        backgroundJLabel.add(feedBack);
        backgroundJLabel.add(customerSupport);
        backgroundJLabel.add(backButton);
        frame.add(backgroundJLabel);
        frame.repaint();
    }
}
