package com.xusheng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author xk
 * @date 2019/1/10 09:31:56
 * @description 注册
 */
public class ZhuCe extends JFrame {
    private JLabel userName;
    private JLabel userKey;
    private JTextField keyField1;
    private JButton subButton;
    private JTextField emailField1;
    private JTextField nameField1;

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ZhuCe inst = new ZhuCe();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });
    }

    public ZhuCe() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            GroupLayout thisLayout = new GroupLayout(getContentPane());
            getContentPane().setLayout(thisLayout);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            userName = new JLabel("\u7528\u6237\u540d\uff1a");
            userKey = new JLabel("\u5bc6\u7801\uff1a");
            JLabel userEmail = new JLabel("\u90ae\u7bb1\uff1a");
            nameField1 = new JTextField();
            nameField1.setColumns(10);
            keyField1 = new JTextField();
            keyField1.setColumns(16);
            emailField1 = new JTextField();
            emailField1.setColumns(20);
            {
                subButton = new JButton("提交");
                subButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        User user0 = new User(nameField1.getText(), keyField1.getText(), emailField1.getText());
                        boolean flag = true;
                        for (User user1 : Load.user) {
                            if (user1.name.equals(nameField1.getText())) {
                                JOptionPane.showMessageDialog(subButton, "用户已存在！");
                                flag = false;
                            } else {
                                keyField1.getText();
                            }
                        }
                        if (flag) {
                            Load.user.add(user0);
                            JOptionPane.showMessageDialog(subButton, "注册成功！");
                            dispose();
                        }

                    }
                });
            }
            thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
                    .addContainerGap(46, 46)
                    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(keyField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userKey, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(17)
                    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userEmail, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(42)
                    .addComponent(subButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE));
            thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
                    .addContainerGap(68, 68)
                    .addGroup(thisLayout.createParallelGroup()
                            .addComponent(userName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userKey, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userEmail, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                    .addGroup(thisLayout.createParallelGroup()
                            .addGroup(thisLayout.createSequentialGroup()
                                    .addComponent(nameField1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(thisLayout.createSequentialGroup()
                                    .addComponent(keyField1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(thisLayout.createSequentialGroup()
                                    .addComponent(emailField1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
                                    .addGap(51)
                                    .addComponent(subButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 65, Short.MAX_VALUE)))
                    .addContainerGap(93, 93));
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }
    }

    class Jbutton implements ActionListener {
        private ZhuCe adaptee;

        Jbutton(ZhuCe adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String username = adaptee.userName.getName();
                String userkey = adaptee.userKey.getText();
                adaptee.subButton.setText("您的用户名是：" + username + "您的输入密码是：" + userkey);
            });
        }
    }
}
