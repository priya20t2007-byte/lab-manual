import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel lblName, lblRoll, lblCourse;
    JTextField txtName, txtRoll;
    JComboBox<String> cmbCourse;
    JButton btnSubmit, btnReset;

    public StudentRegistrationForm() {

        setTitle("Student Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels
        lblName = new JLabel("Student Name:");
        lblRoll = new JLabel("Roll Number:");
        lblCourse = new JLabel("Course:");

        // Text Fields
        txtName = new JTextField();
        txtRoll = new JTextField();

        // Combo Box
        String[] courses = {"B.Tech CSE", "B.Tech ECE", "B.Tech EEE", "B.Tech MECH"};
        cmbCourse = new JComboBox<>(courses);

        // Buttons
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        // Add Components
        add(lblName);
        add(txtName);

        add(lblRoll);
        add(txtRoll);

        add(lblCourse);
        add(cmbCourse);

        add(btnSubmit);
        add(btnReset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSubmit) {

            String name = txtName.getText();
            String roll = txtRoll.getText();
            String course = (String) cmbCourse.getSelectedItem();

            JOptionPane.showMessageDialog(
                    this,
                    "Registration Successful!\n\n"
                            + "Name: " + name
                            + "\nRoll Number: " + roll
                            + "\nCourse: " + course);
        }

        if (e.getSource() == btnReset) {
            txtName.setText("");
            txtRoll.setText("");
            cmbCourse.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
