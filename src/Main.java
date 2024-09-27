import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Form Submission Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create form components
        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(submitButton);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the entered name from the text field
                String name = nameField.getText();

                // Show a dialog box with the entered name
                if (!name.trim().isEmpty()) {
                    var message = "Hello, " + name + "! Your form has been submitted successfully.";
                    JOptionPane.showMessageDialog(frame, message, "Form Submitted", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter your name before submitting.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Set the frame visibility
        frame.setVisible(true);
    }
}
