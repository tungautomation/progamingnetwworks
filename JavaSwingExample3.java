import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JavaSwingExample3 extends JFrame {
    public JavaSwingExample3()
    {
        JButton b = new JButton("Click");
        b.setBounds(130,50,100,40);
        add(b);
        setSize(400,200);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new JavaSwingExample3();
        new JavaSwingExample3();
    }
}

