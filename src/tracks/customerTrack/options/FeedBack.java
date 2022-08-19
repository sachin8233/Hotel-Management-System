package tracks.customerTrack.options;

import javax.swing.*;

public class FeedBack extends JFrame {
    static JTextField topicTextField;
    static JTextArea detailsTextArea;
    static JLabel topicLabel;
    static JLabel detailsLabel;
    static JButton submitButton;

//    public static void main(String[] args) {
//        new FeedBack();
//    }

    public FeedBack() {
        //Defining the frame
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //initializing the variables
        topicLabel = new JLabel("Topic");
        detailsLabel = new JLabel("Details");
        topicTextField = new JTextField();
        detailsTextArea = new JTextArea();
        submitButton = new JButton("Submit");

        //setting the positions of various components
        detailsLabel.setBounds(10, 100, 50, 12);
        topicLabel.setBounds(10, 15, 50, 14);
        topicTextField.setBounds(10, 35, 365, 20);
        detailsTextArea.setBounds(10, 125, 365, 225);
        submitButton.setBounds(150, 360, 80, 30);

        //defining the actions of various buttons
        submitButton.addActionListener(e -> {
            if(topicTextField.getText().isEmpty()){
                JOptionPane.showMessageDialog(getContentPane(),"Please enter a topic");
            }
            else {
                JOptionPane.showMessageDialog(getContentPane(),"Thank you for you feedback");
                frame.dispose();
            }
        });
        frame.add(detailsLabel);
        frame.add(topicLabel);
        frame.add(topicTextField);
        frame.add(detailsTextArea);
        frame.add(submitButton);
        frame.repaint();
    }
}
