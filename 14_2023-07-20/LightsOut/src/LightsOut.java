import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class LightsOut extends JFrame{
    private JPanel panel1;
    private JLabel topLeft;
    private JLabel topCenter;
    private JLabel topRight;
    private JLabel middleLeft;
    private JLabel middleCenter;
    private JLabel middleRight;
    private JLabel bottomLeft;
    private JLabel bottomCenter;
    private JLabel bottomRight;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LightsOut().setVisible(true);
        });
    }

    public LightsOut() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setContentPane(panel1);

        init();

        topLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(topLeft);
                reverse(topCenter);
                reverse(middleLeft);
                judge();
            }
        });

        topCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(topCenter);
                reverse(topLeft);
                reverse(topRight);
                reverse(middleCenter);
                judge();
            }
        });

        topRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(topRight);
                reverse(topCenter);
                reverse(middleRight);
                judge();
            }
        });

        middleLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(middleLeft);
                reverse(topLeft);
                reverse(middleCenter);
                reverse(bottomLeft);
                judge();
            }
        });

        middleCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(middleCenter);
                reverse(topCenter);
                reverse(middleLeft);
                reverse(middleRight);
                reverse(bottomCenter);
                judge();
            }
        });

        middleRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(middleRight);
                reverse(topRight);
                reverse(middleCenter);
                reverse(bottomRight);
                judge();
            }
        });

        bottomLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(bottomLeft);
                reverse(middleLeft);
                reverse(bottomCenter);
                judge();
            }
        });

        bottomCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(bottomCenter);
                reverse(bottomLeft);
                reverse(bottomRight);
                reverse(middleCenter);
                judge();
            }
        });

        bottomRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reverse(bottomRight);
                reverse(bottomCenter);
                reverse(middleRight);
                judge();
            }
        });

    }

    public void reverse(JLabel label){
        if(label.getText().equals("0")) label.setText("1");
        else label.setText("0");
    }

    public void init(){
        topLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        topCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        topRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        middleLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        middleCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        middleRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
        bottomLeft.setText(String.valueOf(new java.util.Random().nextInt(2)));
        bottomCenter.setText(String.valueOf(new java.util.Random().nextInt(2)));
        bottomRight.setText(String.valueOf(new java.util.Random().nextInt(2)));
    }

    public void judge(){
        boolean flg = true;
        if(topLeft.getText().equals("0")) flg = false;
        if(topCenter.getText().equals("0")) flg = false;
        if(topRight.getText().equals("0")) flg = false;
        if(middleLeft.getText().equals("0")) flg = false;
        if(middleCenter.getText().equals("0")) flg = false;
        if(middleRight.getText().equals("0")) flg = false;
        if(bottomLeft.getText().equals("0")) flg = false;
        if(bottomCenter.getText().equals("0")) flg = false;
        if(bottomRight.getText().equals("0")) flg = false;

        if(flg) {
            JOptionPane.showMessageDialog(
                    panel1,
                    "GameClear!!",
                    "3x3 LightsOut",
                    JOptionPane.INFORMATION_MESSAGE
            );

            init();
        }
    }
}
