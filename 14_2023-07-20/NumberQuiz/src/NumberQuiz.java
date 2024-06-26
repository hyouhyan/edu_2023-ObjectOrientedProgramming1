import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberQuiz extends JFrame{
    private JTextField numberInput;
    private JPanel panel1;
    private JButton checkButton;
    private JLabel description;

    private static int answer;

    private static int tryCount = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new NumberQuiz().setVisible(true);
        });
    }

    public NumberQuiz(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);

        setContentPane(panel1);

        init();

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkButton.getText().equals("リセット")){
                    init();
                }
                else {
                    String input = numberInput.getText();

                    if(input.length() > 5){
                        description.setText("数値の範囲は0 ~ 99999です");
                        return;
                    }

                    boolean flg = true;
                    for(char i : input.toCharArray()){
                        if(!Character.isDigit(i)) flg = false;
                    }

                    if(!flg) {
                        description.setText("整数値を入力してください");
                        return;
                    }

                    int num = Integer.parseInt(input);
                    int diff = num - answer;

                    tryCount++;
                    String prn;

                    if (diff <= -10000) prn = ("それよりもっともっと大きい");
                    else if (diff < -1000) prn = ("それよりもっと大きい");
                    else if (diff < 0) prn = ("それより大きい");
                    else if (diff == 0) prn = ("正解");
                    else if (diff < 1000) prn = ("それより小さい");
                    else if (diff < 10000) prn = ("それよりもっと小さい");
                    else prn = ("それよりもっともっと小さい");

                    prn += "（試行回数:" + tryCount + "回)";

                    description.setText(prn);

                    if (diff == 0) {
                        checkButton.setText("リセット");
                    }
                }
            }
        });
    }

    void init(){
        Random rand = new Random();
        answer = rand.nextInt(100000);
        System.out.println(answer);

        checkButton.setText("チェック");
        numberInput.setText("00000");
        description.setText("ランダムに決定した5桁の整数を当てましょう");

        tryCount = 0;
    }
}
