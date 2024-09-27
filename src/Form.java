import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Form extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private CatppuccinLabel phoneLabel;
    private CatppuccinTextField phoneField;
    private CatppuccinLabel dateLabel;
    private CatppuccinTextField dateField;
    private JSpinner dateSpinner;
    private CatppuccinLabel addressLabel;
    private CatppuccinTextField addressField;
    private CatppuccinLabel genderLabel;
    private ButtonGroup genderOptions;
    private JRadioButton genderMale;
    private JRadioButton genderFemale;
    private CatppuccinLabel hobbyLabel;
    private List<JCheckBox> hobbyList;
    private JCheckBox hobbySports;
    private JCheckBox hobbyReading;
    private JCheckBox hobbyCoding;
    private CatppuccinLabel cityLabel;
    private JComboBox<String> cityField;
    private CatppuccinLabel skillsLabel;
    private JList<String> skillsField;


    public Form() {
        initComponents();
    }

    public static void main(String[] args) {
        new Form().setVisible(true);
    }

    private void initComponents() {
        setTitle("Student Resume");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#1e1e2e"));
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        nameLabel = new CatppuccinLabel("Name:");
        nameField = new CatppuccinTextField(20);

        phoneLabel = new CatppuccinLabel("Phone:");
        phoneField = new CatppuccinTextField(20);

        emailLabel = new CatppuccinLabel("Email:");
        emailField = new CatppuccinTextField(20);

        dateLabel = new CatppuccinLabel("Date of Birth:");
        dateSpinner = new CatppuccinDateSpinner();

        addressLabel = new CatppuccinLabel("Address:");
        addressField = new CatppuccinTextField(20);

        genderLabel = new CatppuccinLabel("Gender:");
        genderOptions = new ButtonGroup();
        genderMale = new CatppuccinRadioButton("Male");
        genderFemale = new CatppuccinRadioButton("Female");
        genderOptions.add(genderMale);
        genderOptions.add(genderFemale);

        hobbyLabel = new CatppuccinLabel("Hobbies:");
        hobbyList = new ArrayList<JCheckBox>();
        hobbySports = new CatppuccinCheckBox("Sports");
        hobbyList.add(hobbySports);
        hobbyReading = new CatppuccinCheckBox("Reading");
        hobbyList.add(hobbyReading);
        hobbyCoding = new CatppuccinCheckBox("Coding");
        hobbyList.add(hobbyCoding);

        cityLabel = new CatppuccinLabel("City:");
        cityField = new CatppuccinComboBox<>(new String[]{"Mumbai", "Delhi", "Kolkata"});

        skillsLabel = new CatppuccinLabel("Skills:");
        skillsField = new CatppuccinList<>(new String[]{"Python", "Java", "C++"});

        JButton submitButton = new CatppuccinButton("Submit");
        submitButton.addActionListener(this);

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        mainPanel.add(phoneLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(phoneField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        mainPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(emailField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        mainPanel.add(dateLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(dateSpinner, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        mainPanel.add(addressLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(addressField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        mainPanel.add(genderLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(genderMale, constraints);
        constraints.gridx = 2;
        mainPanel.add(genderFemale, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        mainPanel.add(hobbyLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(hobbySports, constraints);

        constraints.gridx = 2;
        mainPanel.add(hobbyReading, constraints);

        constraints.gridx = 3;
        mainPanel.add(hobbyCoding, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        mainPanel.add(cityLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(cityField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        mainPanel.add(skillsLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 3;
        mainPanel.add(skillsField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(submitButton, constraints);

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gender = Collections.list(genderOptions.getElements())
                .stream()
                .filter(AbstractButton::isSelected)
                .map(AbstractButton::getText)
                .findFirst()
                .orElse(null);

        String hobbies = hobbyList.stream()
                .filter(AbstractButton::isSelected)
                .map(AbstractButton::getText)
                .collect(Collectors.joining(", "));

        String message = "Name: " + nameField.getText() +
                "\nEmail: " + emailField.getText() +
                "\nPhone: " + phoneField.getText() +
                "\nAddress: " + addressField.getText() +
                "\nGender: " + gender +
                "\nHobbies: " + hobbies +
                "\nCity: " + cityField.getSelectedItem() +
                "\nSkills: " + String.join(", ", skillsField.getSelectedValuesList());

        JOptionPane.showMessageDialog(
                this,
                message,
                "Form Submitted",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
