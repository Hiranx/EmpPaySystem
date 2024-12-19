import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpReg extends JFrame{
    private JPanel main;
    private JTextField empName;
    private JButton submitButton;
    private JLabel id;
    private JTextField textField1;
    private JLabel Exlvl;
    private JComboBox<String> comboBox1;

    public EmpReg() {
        comboBox1.addItem("Junior");
        comboBox1.addItem("Mid-level");
        comboBox1.addItem("Senior");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(submitButton,empName.getText()+", Hello");
            }
        });
    }

    public static void main(String[] args) {
        EmpReg e = new EmpReg();
        e.setContentPane(e.main);
        e.setSize(400,400);
        e.setVisible(true);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
