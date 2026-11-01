import javax.swing.*;
import java.awt.*;

public class StudentManagement extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField marksField;

    private StudentDAO dao = new StudentDAO();

    public StudentManagement() {

        setTitle("Student Details Management System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 15));
        panel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        panel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Marks / CGPA:"));
        marksField = new JTextField();
        panel.add(marksField);

        JButton addButton = new JButton("Add Student");
        JButton clearButton = new JButton("Clear");

        panel.add(addButton);
        panel.add(clearButton);

        add(panel);

        addButton.addActionListener(e -> addStudent());

        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void addStudent() {

        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            double marks = Double.parseDouble(
                marksField.getText().trim()
            );

            if (name.isEmpty() || marks < 0 || marks > 100) {
                JOptionPane.showMessageDialog(
                    this, "Enter valid student details!"
                );
                return;
            }

            Student student = new Student(id, name, marks);

            if (dao.addStudent(student)) {
                JOptionPane.showMessageDialog(
                    this, "Student details added successfully!"
                );
                clearFields();
            } else {
                JOptionPane.showMessageDialog(
                    this, "Failed to add student!"
                );
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Enter valid ID and Marks!"
            );
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        marksField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new StudentManagement()
        );
    }
}
