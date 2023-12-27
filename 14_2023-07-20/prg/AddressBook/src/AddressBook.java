import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook extends JFrame{
    private JPanel panel1;
    private JLabel title;
    private JTextField nameField;
    private JTextField phonenumField;
    private JButton addBtn;
    private JLabel name;
    private JLabel phoneNumber;
    private JButton button1;
    private JList list1;

    List<Addresses> addressBook = new ArrayList<>();

    DefaultListModel model = new DefaultListModel();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new AddressBook().setVisible(true);
        });
    }

    public AddressBook() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        setContentPane(panel1);
        list1.setModel(model);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressBook.add(new Addresses(nameField.getText(), phonenumField.getText()));

                model.addElement(nameField.getText() + ":" + phonenumField.getText());
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rtn = "[";
                for(Addresses address: addressBook){
                    if(rtn.equals("[")) rtn += "{\"name\":\"" + address.getName() + "\",\"phoneNumber\":\"" + address.getPhonenum() + "\"}";
                    else rtn += ",{\"name\":\"" + address.getName() + "\",\"phoneNumber\":\"" + address.getPhonenum() + "\"}";
                }
                rtn += "]";

                saveTextFileActionPerformed(rtn);
            }
        });
    }

    private void saveTextFileActionPerformed(String content){
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));

        File f = null;

        // ダイアログを開き、戻り値を取得
        int selected = jfc.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                f = jfc.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default: // case JFileChooser.ERROR_OPTION: でも良い
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
                break;
        }

        if (f != null) {

            // 書き込み対象をBufferedWriterで開く
            try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), Charset.defaultCharset())) {
                // テキスト領域から文字列を読み込み(Scannerを使用するパターン)
                Scanner sc = new Scanner(content);
                while (sc.hasNextLine()) {
                    bw.append(sc.nextLine());
                    bw.newLine();
                }
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
            }
        }
    }


}
