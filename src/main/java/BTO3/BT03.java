/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTO3;

/**
 *
 * @author Administrator
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BT03 extends JFrame {
    private JLabel lbNum1, lbNum2, lbResult, lbPhepTinh;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btTinh, btNhapLai;
    private JComboBox<String> cmbPhepTinh;

    public BT03(String title) {
        super(title);
        createGUI();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 10, 10));

        lbNum1 = new JLabel("Num 1:");
        txtNum1 = new JTextField(10);
        p.add(lbNum1);
        p.add(txtNum1);

        lbNum2 = new JLabel("Num 2:");
        txtNum2 = new JTextField(10);
        p.add(lbNum2);
        p.add(txtNum2);

        lbPhepTinh = new JLabel("Phép tính:");
        String[] phepTinh = {"+", "-", "*", "/"};
        cmbPhepTinh = new JComboBox<>(phepTinh);
        cmbPhepTinh.setSelectedIndex(0); 
        p.add(lbPhepTinh);
        p.add(cmbPhepTinh);

        lbResult = new JLabel("Result:");
        txtResult = new JTextField(10);
        txtResult.setEditable(false);
        p.add(lbResult);
        p.add(txtResult);

        btTinh = new JButton("Tính");
        btNhapLai = new JButton("Nhập lại");
        p.add(btTinh);
        p.add(btNhapLai);

        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhToan();
            }
        });

        btNhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhapLai();
            }
        });

        add(p);
    }

    private void tinhToan() {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double result = 0;
            String phepTinh = (String) cmbPhepTinh.getSelectedItem();

            switch (phepTinh) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        txtResult.setText("Lỗi chia cho 0");
                        return;
                    }
                    break;
            }
            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            txtResult.setText("Lỗi nhập liệu");
        }
    }

    private void nhapLai() {
        txtNum1.setText("");
        txtNum2.setText("");
        txtResult.setText("");
        cmbPhepTinh.setSelectedIndex(0); 
        txtNum1.requestFocus(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BT03 frame = new BT03("Simple Calculator");
            frame.setVisible(true);
        });
    }
}
