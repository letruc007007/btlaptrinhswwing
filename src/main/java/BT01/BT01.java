/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BT01;

/**
 *
 * @author ADMIN
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BT01 extends JFrame {
    private JLabel lbSo1, lbSo2, lbKetQua;
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btCong, btTru, btNhan, btChia, btKetThuc;

    public BT01(String title) {
        super(title);
        createGUI();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 10, 10));

        lbSo1 = new JLabel("Số 1:");
        txtSo1 = new JTextField(10);
        p.add(lbSo1);
        p.add(txtSo1);

        lbSo2 = new JLabel("Số 2:");
        txtSo2 = new JTextField(10);
        p.add(lbSo2);
        p.add(txtSo2);

        lbKetQua = new JLabel("Kết quả:");
        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);
        p.add(lbKetQua);
        p.add(txtKetQua);

        JPanel p1 = new JPanel();
        p1.add(btCong = new JButton("Cộng"));
        p1.add(btTru = new JButton("Trừ"));
        p1.add(btNhan = new JButton("Nhân"));
        p1.add(btChia = new JButton("Chia"));
        p1.add(btKetThuc = new JButton("Kết thúc"));

        setLayout(new BorderLayout());
        add(p, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);

        btCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq = x + y;
                txtKetQua.setText(String.valueOf(kq));
            }
        });

        btTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq = x - y;
                txtKetQua.setText(String.valueOf(kq));
            }
        });

        btNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq = x * y;
                txtKetQua.setText(String.valueOf(kq));
            }
        });

        btChia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq = x / y;
                txtKetQua.setText(String.valueOf(kq));
            }
        });

        btKetThuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chon = JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng ứng dụng?");
                if (chon == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BT01 frame = new BT01("Máy Tính Đơn Giản");
                frame.setVisible(true);
            }
        });
    }
}
