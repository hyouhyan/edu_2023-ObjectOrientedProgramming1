import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickCounter extends JFrame{
    private JButton button1;
    private JPanel panel1;
    private JButton resetButton;
    private JButton button3;
    private javax.swing.JLabel JLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ClickCounter().setVisible(true);
        });
    }

    public ClickCounter(){
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 300, 200);

        setContentPane(panel1);
//        setContentPane(button1);
//        setContentPane(resetButton);
//        setContentPane(button3);
//        setContentPane(JLabel);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel.setText("0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(JLabel.getText());
                num--;
                JLabel.setText(Integer.toString(num));
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(JLabel.getText());
                num++;
                JLabel.setText(Integer.toString(num));
            }
        });
    }
}
