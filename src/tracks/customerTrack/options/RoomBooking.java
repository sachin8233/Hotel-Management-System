package tracks.customerTrack.options;

import external_classes.DateChooser;
import tracks.customerTrack.OptionsForCustomer;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class RoomBooking extends JFrame {
    static JLabel startDatePanel;
    static JLabel endDatePanel;
    static JLabel typeOfRoom;
    static JLabel totalCost;
    static JButton backButton;
    static JButton startDateChoose;
    static JButton endDateChoose;
    static JButton bookRoom;
    static JLabel displayStartDate;
    static JLabel displayEndDate;
    static JComboBox<NamesOFRooms> namesOfRooms = new JComboBox<>();
    static JLabel costOfRoom;

    public static void main(String[] args) {
        new RoomBooking();
    }

    public RoomBooking() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        namesOfRooms.removeAllItems();
        addRooms();

        //Defining the frame
        JFrame frame = new JFrame();
        frame.setTitle("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        startDatePanel = setPropertiesOfJLabel("Start Date");
        endDatePanel = setPropertiesOfJLabel("End Date");
        typeOfRoom = setPropertiesOfJLabel("Type of Room");
        totalCost = setPropertiesOfJLabel("Total Cost");
        backButton = new JButton("Back");
        startDateChoose = new JButton("Choose Date");
        endDateChoose = new JButton("Choose End date");
        displayStartDate = setPropertiesOfJLabel(dtf.format(now));
        displayEndDate = setPropertiesOfJLabel(dtf.format(now));
        costOfRoom = setPropertiesOfJLabel("0");
        bookRoom=new JButton("Book Room");

        //setting the positions of various components
        startDatePanel.setBounds(500, 200, 400, 50);
        endDatePanel.setBounds(500, 400, 400, 50);
        typeOfRoom.setBounds(500, 600, 400, 50);
        totalCost.setBounds(500, 750, 400, 50);
        backButton.setBounds(0, 0, 80, 30);
        startDateChoose.setBounds(1150, 200, 150, 30);
        endDateChoose.setBounds(1150, 400, 150, 30);
        namesOfRooms.setBounds(900, 600, 150, 30);
        displayStartDate.setBounds(900, 200, 200, 50);
        displayEndDate.setBounds(900, 400, 200, 50);
        costOfRoom.setBounds(900, 750, 600, 50);
        bookRoom.setBounds(700,100,200,50);

        //defining the actions of various buttons
        backButton.addActionListener(e -> {
            new OptionsForCustomer();
            dispose();
        });
        startDateChoose.addActionListener(e -> DateChooser.DateChooserExample(displayStartDate));
        endDateChoose.addActionListener(e -> DateChooser.DateChooserExample(displayEndDate));
        namesOfRooms.addItemListener(e -> new CostCalculator(costOfRoom, Objects.requireNonNull(namesOfRooms.getSelectedItem()).toString()));
        bookRoom.addActionListener(e -> {
            if(costOfRoom.getText().toString().equals("0") || costOfRoom.getText().toString().equals("Choose the dates correctly") ){
                JOptionPane.showMessageDialog(getContentPane(),"Please choose date and room correctly");
            }
            else {
                JOptionPane.showMessageDialog(getContentPane(),"Hurrah!!! Room Booked");
                new OptionsForCustomer();
                dispose();
            }
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(startDatePanel);
        backgroundJLabel.add(endDatePanel);
        backgroundJLabel.add(typeOfRoom);
        backgroundJLabel.add(totalCost);
        backgroundJLabel.add(backButton);
        backgroundJLabel.add(startDateChoose);
        backgroundJLabel.add(endDateChoose);
        backgroundJLabel.add(namesOfRooms);
        backgroundJLabel.add(displayStartDate);
        backgroundJLabel.add(displayEndDate);
        backgroundJLabel.add(costOfRoom);
        backgroundJLabel.add(bookRoom);
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
    //for adding types of rooms to the JCombo Box
    private static void addRooms() {
        for (NamesOFRooms i : NamesOFRooms.values()) {
            namesOfRooms.addItem(i);
        }
    }
}
// Contains all the types of rooms present in the hotel
enum NamesOFRooms {
    SingleRoom, DoubleRoom, KingSize, QueenSize
}

// for calculating the total amount a person will have to par
class CostCalculator {
    static int diffInDays;

    //Calculate the number
    CostCalculator(JLabel cost, String room) {
        NumberOfDays();
        if (diffInDays < 0) {
            cost.setText("Choose the dates correctly");
        } else {
            if(diffInDays==0){
                diffInDays++;
            }
            switch (room) {
                case "SingleRoom":
                    cost.setText(String.valueOf(500*diffInDays));
                    break;
                case "DoubleRoom":
                    cost.setText(String.valueOf(700*diffInDays));
                    break;
                case "KingSize":
                    cost.setText(String.valueOf(1100*diffInDays));
                    break;
                case "QueenSize":
                    cost.setText(String.valueOf(900*diffInDays));
                    break;
                default:
                    cost.setText("Error");

            }
        }
    }

    //Calculate the number of days
    private static void NumberOfDays() {
        String s1 = RoomBooking.displayStartDate.getText();
        String s2 = RoomBooking.displayEndDate.getText();
        // System.out.println(s1+" "+s2);
        int day1, day2, mon1, mon2, ye1, ye2, totalDays;
        day1 = Integer.parseInt(s1.substring(8, 10));
        day2 = Integer.parseInt(s2.substring(8, 10));
        mon1 = Integer.parseInt(s1.substring(8, 10));
        mon2 = Integer.parseInt(s2.substring(8, 10));
        ye1 = Integer.parseInt(s1.substring(8, 10));
        ye2 = Integer.parseInt(s2.substring(8, 10));
        totalDays = day2 - day1;
        totalDays = totalDays + (mon2 - mon1);
        totalDays = totalDays + (ye2 - ye1);
        diffInDays = totalDays;

    }
}
