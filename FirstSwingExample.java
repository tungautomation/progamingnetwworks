import javax.swing.JButton;
import javax.swing.JFrame;
public class FirstSwingExample 
    {
        public static void main(String[] args) 
        {
            JFrame f  = new JFrame();

            JButton b = new JButton("Click");
            b.setBounds(130,50,100,40);
            f.setTitle("Ví dụ Java Swing");
            f.add(b);

            f.setSize(400,200);
            f.setLayout(null);
            f.setVisible(true);
        }
    }