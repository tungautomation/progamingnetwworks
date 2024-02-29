import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JavaSwingExample2 extends JFrame {
    private JTextArea textArea;
    private JButton openButton;
    private JButton clearButton;

    public JavaSwingExample2() {
        super("File Input Form");

        // Khởi tạo các thành phần của giao diện
        textArea = new JTextArea(20, 40);
        openButton = new JButton("Open File");
        clearButton = new JButton("Clear file");

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                textArea.setText("");
            }
        });

        // Tạo một ActionListener cho nút Open File
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hiển thị hộp thoại chọn tập tin và lấy đường dẫn của tập tin được chọn
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(JavaSwingExample2.this);

                // Nếu người dùng đã chọn một tập tin
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Lấy đường dẫn của tập tin
                    File selectedFile = fileChooser.getSelectedFile();
                    // Đọc nội dung của tập tin và hiển thị trên JTextArea
                    readFile(selectedFile);
                }
            }
        });

        // Sử dụng LayoutManager để sắp xếp các thành phần trên giao diện
        JPanel panel = new JPanel();
        panel.add(openButton);

        // Thêm các thành phần vào JFrame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(clearButton);
        // Cấu hình các thuộc tính của JFrame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Phương thức để đọc nội dung của tập tin và hiển thị trên JTextArea
    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText(""); // Xóa nội dung cũ trong JTextArea trước khi hiển thị tập tin mới
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n"); // Thêm nội dung từng dòng vào JTextArea
            }
        } catch (IOException ex) {
            // ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo một đối tượng của lớp JavaSwingExample2
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaSwingExample2();
            }
        });
    }
}
