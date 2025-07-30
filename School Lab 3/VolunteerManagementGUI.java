import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolunteerManagementGUI {
    private JFrame frame;
    private JTextField idField;
    private JTextField nameField;
    private JTextField sexField;
    private JTextField ageField;

    public VolunteerManagementGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 50, 46, 14);
        frame.getContentPane().add(lblId);

        idField = new JTextField();
        idField.setBounds(100, 47, 86, 20);
        frame.getContentPane().add(idField);
        idField.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 100, 46, 14);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(100, 97, 86, 20);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(50, 150, 46, 14);
        frame.getContentPane().add(lblSex);

        sexField = new JTextField();
        sexField.setBounds(100, 147, 86, 20);
        frame.getContentPane().add(sexField);
        sexField.setColumns(10);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(50, 200, 46, 14);
        frame.getContentPane().add(lblAge);

        ageField = new JTextField();
        ageField.setBounds(100, 197, 86, 20);
        frame.getContentPane().add(ageField);
        ageField.setColumns(10);

        JButton addButton = new JButton("Add Volunteer");
        addButton.setBounds(200, 50, 117, 23);
        frame.getContentPane().add(addButton);

        JButton deleteButton = new JButton("Delete Volunteer");
        deleteButton.setBounds(200, 100, 117, 23);
        frame.getContentPane().add(deleteButton);

        JButton updateButton = new JButton("Update Volunteer");
        updateButton.setBounds(200, 150, 117, 23);
        frame.getContentPane().add(updateButton);

        JButton queryButton = new JButton("Query Volunteer");
        queryButton.setBounds(200, 200, 117, 23);
        frame.getContentPane().add(queryButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String sex = sexField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    VolunteerDAO dao = new VolunteerDAO(DatabaseConnection.getConnection());
                    dao.addVolunteer(id, name, sex, age);
                    dao.displayAllVolunteers();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    VolunteerDAO dao = new VolunteerDAO(DatabaseConnection.getConnection());
                    dao.deleteVolunteer(id);
                    dao.displayAllVolunteers();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    VolunteerDAO dao = new VolunteerDAO(DatabaseConnection.getConnection());
                    dao.updateVolunteer(id, name);
                    dao.displayAllVolunteers();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    VolunteerDAO dao = new VolunteerDAO(DatabaseConnection.getConnection());
                    dao.queryVolunteer(id);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new VolunteerManagementGUI().frame.setVisible(true);
    }
}