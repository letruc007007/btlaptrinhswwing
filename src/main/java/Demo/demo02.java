    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo02 extends JFrame {
    private JLabel lbNum1, lbNum2, lbOp, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btTinh, btNhapLai;
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;

    public demo02(String title) {
        super(title);
        createGUI();
        setSize(400, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 2, 10, 10));
        
        lbNum1 = new JLabel("Num 1:");
        txtNum1 = new JTextField(10);
        p.add(lbNum1);
        p.add(txtNum1);

        
        lbNum2 = new JLabel("Num 2:");
        txtNum2 = new JTextField(10);
        p.add(lbNum2);
        p.add(txtNum2);

        JPanel pPhepTinh = new JPanel();
        rdCong = new JRadioButton("+");
        rdTru = new JRadioButton("-");
        rdNhan = new JRadioButton("*");
        rdChia = new JRadioButton("/");
        pPhepTinh.add(rdCong);
        pPhepTinh.add(rdTru);
        pPhepTinh.add(rdNhan);
        pPhepTinh.add(rdChia);
        p.add(new JLabel("Phép tính:"));
        p.add(pPhepTinh);

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

            if (rdCong.isSelected()) {
                result = num1 + num2;
            } else if (rdTru.isSelected()) {
                result = num1 - num2;
            } else if (rdNhan.isSelected()) {
                result = num1 * num2;
            } else if (rdChia.isSelected()) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    txtResult.setText("Lỗi chia cho 0");
                    return;
                }
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
        rdCong.setSelected(false);
        rdTru.setSelected(false);
        rdNhan.setSelected(false);
        rdChia.setSelected(false);
    }

    public static void main(String[] args) {
        demo02 frm = new demo02("Simple Calculator");
        frm.setVisible(true);
    }
}