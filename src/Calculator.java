import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;
    private final JButton[] numberButtons;
    private final JButton addButton;
    private final JButton subButton;
    private final JButton mulButton;
    private final JButton divButton;
    private final JButton decButton;
    private final JButton clrButton;
    private final JButton eqlButton;
    private final JPanel panel;

    // Variables for calculation
    private double num1 = 0;
    private double num2 = 0;
    private double result = 0;
    private char operator;

    public Calculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Text field setup
        display = new CatppuccinTextField(10);
        display.setEditable(false);
//        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Number buttons setup
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new CatppuccinButton(i);
            numberButtons[i].addActionListener(this);
        }

        addButton = new CatppuccinButton('+');
        subButton = new CatppuccinButton('-');
        mulButton = new CatppuccinButton('*');
        divButton = new CatppuccinButton('/');
        decButton = new CatppuccinButton('.');
        clrButton = new CatppuccinButton("Clear");
        eqlButton = new CatppuccinButton('=');

        // Adding action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        decButton.addActionListener(this);
        clrButton.addActionListener(this);
        eqlButton.addActionListener(this);

        // Panel setup for buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(30, 30, 46));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        // Clear button at the bottom
        add(clrButton, BorderLayout.SOUTH);

        // Adding panel to the frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number and decimal button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        // Handling operator button clicks
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Handling equals button click
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        // Handling clear button click
        if (e.getSource() == clrButton) {
            display.setText("");
        }
    }
}
