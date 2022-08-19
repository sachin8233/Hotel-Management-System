package tracks.customerTrack.options;

import tracks.customerTrack.OptionsForCustomer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class MyBookingsPage extends JFrame {
    static JComboBox chooseOrderNumber;
    static JLabel roomType, displayRoomType;
    static JLabel startDate, displayStartDate;
    static JLabel endDate, displayEndDate;
    static JButton backButton;
//        public static void main(String[] args) {
//        new MyBookingsPage();
//
//    }

    public MyBookingsPage() {
        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        chooseOrderNumber = new JComboBox();
        roomType = setPropertiesOfJLabel("Room Type");
        startDate = setPropertiesOfJLabel("Start Date");
        endDate = setPropertiesOfJLabel("End date");
        displayRoomType = setPropertiesOfJLabel("Select Order Number");
        displayStartDate = setPropertiesOfJLabel("Select Order Number");
        displayEndDate = setPropertiesOfJLabel("Select Order Number");
        backButton=new JButton("Back");

        //setting the positions of various components
        chooseOrderNumber.setBounds(700, 80, 100, 30);
        roomType.setBounds(400, 220, 200, 50);
        startDate.setBounds(400, 420, 200, 50);
        endDate.setBounds(400, 620, 200, 50);
        displayRoomType.setBounds(900, 220, 400, 50);
        displayStartDate.setBounds(900, 420, 400, 50);
        displayEndDate.setBounds(900, 620, 400, 50);
        backButton.setBounds(0,0,100,30);

        InfoSetter.setNumberOfOrders(chooseOrderNumber);

        //defining the actions of various buttons
        chooseOrderNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                new InfoSetter(Objects.requireNonNull(chooseOrderNumber.getSelectedItem()).toString(), displayRoomType, displayStartDate, displayEndDate);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OptionsForCustomer();
                dispose();
            }
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(chooseOrderNumber);
        backgroundJLabel.add(roomType);
        backgroundJLabel.add(startDate);
        backgroundJLabel.add(endDate);
        backgroundJLabel.add(displayRoomType);
        backgroundJLabel.add(displayStartDate);
        backgroundJLabel.add(displayEndDate);
        backgroundJLabel.add(backButton);
        frame.add(backgroundJLabel);
        frame.repaint();


    }
// A customized JLabel
    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
}

class InfoSetter {
    InfoSetter(String s, JLabel roomType, JLabel startDate, JLabel endDate) {
        String x = s.substring(6, 7);
        roomType.setText("Dummy Room Type " + x);
        startDate.setText("Dummy Start Date " + x);
        endDate.setText("Dummy End Date " + x);


    }

    public static void setNumberOfOrders(JComboBox comboBox) {
        for (int i = 1; i <= 3; i++) {
            comboBox.addItem("Order " + i);
        }

    }
}
