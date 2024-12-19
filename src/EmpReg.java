import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpReg extends JFrame{
    private JPanel main;
    private JTextField empName;
    private JButton submitButton;
    private JLabel id;
    private JTextField nic;
    private JLabel Exlvl;
    private JComboBox<String> comboBox1;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/emp_payroll";
    private static final String DB_USER = "root"; // Replace with your username
    private static final String DB_PASSWORD = "hiran9204"; // Replace with your password

    public EmpReg() {
        comboBox1.addItem("Junior");
        comboBox1.addItem("Mid-level");
        comboBox1.addItem("Senior");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = empName.getText();
                String NIC = nic.getText();
                String expL = (String) comboBox1.getSelectedItem();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(submitButton, "Name cannot be empty.");
                } else {
                    // Save data to MySQL
                    saveEmployeeToDatabase(name, expL, NIC);
                }

            }
        });
    }

    private void saveEmployeeToDatabase(String name, String expL, String NIC) {
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
            String query = "INSERT INTO employees(name,NIC,expL) VALUES(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,NIC);
            statement.setString(3,expL);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Employee saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save employee.");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmpReg e = new EmpReg();
        e.setContentPane(e.main);
        e.setSize(400,400);
        e.setVisible(true);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
