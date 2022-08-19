package external_classes;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class DateChooser {
    static String date = "";

//    public static void main(String[] args) {
//        DateChooser.DateChooserExample(new JLabel());
//    }
    public static void DateChooserExample(JLabel displayDate) {

        JButton chooseButton = new JButton("Choose");
        JFrame testFrame = new JFrame();
        testFrame.setUndecorated(true);
        testFrame.setLocationRelativeTo(null);
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BorderLayout());
        testFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        testFrame.setSize(325, 40);
        JPanel jPanel = new JPanel();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl picker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        picker.setTextEditable(true);
        picker.setShowYearButtons(true);
        jPanel.add(picker);
        JPanel DatePanel = new JPanel();
        DatePanel.setLayout(new BorderLayout());
        DatePanel.add(jPanel, BorderLayout.WEST);
        finalPanel.add(DatePanel);
        finalPanel.setBounds(0, 0, 220, 50);
        chooseButton.setBounds(220, 3, 100, 30);
        testFrame.setLayout(null);
        testFrame.add(finalPanel);
        testFrame.add(chooseButton);
        testFrame.setVisible(true);


        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testFrame.dispose();
                date=picker.getJFormattedTextField().getText();
                displayDate.setText(date);
                //System.out.println(date);
            }
        });
        //System.out.println("date");

    }
    public static String getDate(){
        return date;
    }


}

