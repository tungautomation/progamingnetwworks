import javax.swing.*;
import java.awt.event.*;

public class controlerbac2 extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public controlerbac2() {
        super("Input Output Form");
        inputField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        outputArea = new JTextArea(10, 20);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                outputArea.append(inputText + "\n");
                inputField.setText("");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Input: "));
        panel.add(inputField);
        panel.add(submitButton);

        add(panel, "North");
        add(new JScrollPane(outputArea), "Center");

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new controlerbac2();
            }
        });
    }
}
