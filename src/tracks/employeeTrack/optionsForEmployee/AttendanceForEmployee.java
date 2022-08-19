package tracks.employeeTrack.optionsForEmployee;

import tracks.employeeTrack.OptionsForEmployee;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AttendanceForEmployee extends JFrame {
    static JLabel date, displayDate;
    static JLabel chooseShift;
    static JLabel startTime, displayStartTime;
    static JLabel endTime,displayEndTime;
    static JComboBox shiftSelector;
    static JButton markAttendance,backButton;
//    public static void main(String[] args) {
//        new AttendanceForEmployee();
//    }
    public AttendanceForEmployee(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        //Defining the frame
        JFrame frame = new JFrame("Hotel Mariot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //initializing the variables
        date=setPropertiesOfJLabel("Today's date");
        displayDate=setPropertiesOfJLabel(dtf.format(now));
        chooseShift=setPropertiesOfJLabel("Choose Shift");
        shiftSelector=new JComboBox();
        markAttendance=new JButton("Mark Attendance");
        startTime=setPropertiesOfJLabel("Start Time");
        endTime=setPropertiesOfJLabel("End Time");
        displayStartTime=setPropertiesOfJLabel("00:00");
        displayEndTime=setPropertiesOfJLabel("05:00");
        backButton=new JButton("Back");

        //setting the positions of various components
        date.setBounds(450,150,200,50);
        displayDate.setBounds(850,150,200,50);
        chooseShift.setBounds(450,250,200,50);
        shiftSelector.setBounds(850,250,200,30);
        startTime.setBounds(450,350,200,50);
        endTime.setBounds(450,450,200,50);
        displayStartTime.setBounds(850,350,200,50);
        displayEndTime.setBounds(850,450,200,50);
        markAttendance.setBounds(650,550,200,30);
        backButton.setBounds(0,0,80,30);

        AddShifts(shiftSelector);

        //defining the actions of various buttons
        shiftSelector.addItemListener(e -> TimeSetter(Objects.requireNonNull(shiftSelector.getSelectedItem()).toString(),displayStartTime,displayEndTime));
        markAttendance.addActionListener(e -> {
            JOptionPane.showMessageDialog(getContentPane(),"Attendance marked");
            new OptionsForEmployee();
            dispose();
        });
        backButton.addActionListener(e -> {
            new OptionsForEmployee();
            dispose();
        });

        ImageIcon background_pic = new ImageIcon("src\\resources\\hotel.jpg");
        JLabel backgroundJLabel = new JLabel("", background_pic, JLabel.LEADING);
        backgroundJLabel.setBounds(0, 0, 1920, 1080);
        backgroundJLabel.add(date);
        backgroundJLabel.add(displayDate);
        backgroundJLabel.add(chooseShift);
        backgroundJLabel.add(shiftSelector);
        backgroundJLabel.add(markAttendance);
        backgroundJLabel.add(displayStartTime);
        backgroundJLabel.add(displayEndTime);
        backgroundJLabel.add(startTime);
        backgroundJLabel.add(endTime);
        backgroundJLabel.add(backButton);
        frame.add(backgroundJLabel);
        frame.repaint();

    }
    // a customized JLabel
    private static JLabel setPropertiesOfJLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(false);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
    //for adding shift numbers to the JComboBox
    private static void AddShifts(JComboBox box){
        for(int i=1;i<=5;i++){
            box.addItem("Shift "+i);
        }
    }
    // to set the time as per the chosen shift
    private static void TimeSetter(String s,JLabel time1, JLabel time2){
        int a=Integer.parseInt(s.substring(6,7));
        switch (a){
            case 2:
                time1.setText("06:00");
                time2.setText("10:00");
                break;
            case 3:
                time1.setText("11:00");
                time2.setText("15:00");
                break;
            case 4:
                time1.setText("16:00");
                time2.setText("20:00");
                break;
            case 5:
                time1.setText("21:00");
                time2.setText("00:00");
                break;
            default:
                time1.setText("00:00");
                time2.setText("05:00");
        }

    }
}
