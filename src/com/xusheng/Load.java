package com.xusheng;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author xk
 * @date 2019/1/10 09:28:13
 * @description µÇÂ¼
 */
public class Load extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField keyField;
    private JButton load;
    private JTextField nameField;
    static ArrayList<User> user = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Load inst = new Load();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });
    }

    public Load() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            GroupLayout thisLayout = new GroupLayout(getContentPane());
            getContentPane().setLayout(thisLayout);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JLabel userName = new JLabel("ÓÃ»§Ãû£º");
            JLabel userKey = new JLabel(" ÃÜÂë£º");
            nameField = new JTextField();
            nameField.setColumns(10);
            keyField = new JTextField();
            keyField.setColumns(16);
            load = new JButton("µÇÂ¼");
            load.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean flag = false;
                    for (User user1 : user) {
                        if (user1.name.equals(nameField.getText())) {
                            if (user1.key.equals(keyField.getText())) {
                                JOptionPane.showMessageDialog(load, "µÇÂ½³É¹¦£¡ÄúµÄÓÊÏäÊÇ£º" + user1.email);
                                keyField.setText("");
                                nameField.setText("");
                            } else {
                                JOptionPane.showMessageDialog(load, "ÃÜÂë´íÎó£¡");
                            }
                        } else {
                            JOptionPane.showMessageDialog(load, "ÓÃ»§²»´æÔÚ£¡");
                        }
                    }
                }
            });
            JButton sign;
            {
                sign = new JButton("×¢²á");
                sign.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ZhuCe inst = new ZhuCe();
                        inst.setLocationRelativeTo(null);
                        inst.setVisible(true);
                    }
                });
            }
            thisLayout.setVerticalGroup(thisLayout.createSequentialGroup().addContainerGap(64, 64)
                    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29)
                    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(keyField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userKey, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40)
                    .addGroup(thisLayout.createParallelGroup().addGroup(GroupLayout.Alignment.LEADING,
                            thisLayout.createSequentialGroup()
                                    .addComponent(load, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING,
                                    thisLayout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sign, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(62, 62));
            thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup().addContainerGap(66, 66)
                    .addGroup(thisLayout.createParallelGroup()
                            .addComponent(userName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53,
                                    GroupLayout.PREFERRED_SIZE)
                            .addComponent(userKey, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53,
                                    GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(thisLayout.createParallelGroup()
                            .addGroup(thisLayout.createSequentialGroup().addComponent(nameField,
                                    GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                            .addGroup(thisLayout.createSequentialGroup().addComponent(keyField,
                                    GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
                                    .addComponent(load, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addGap(43)
                                    .addComponent(sign, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(81, Short.MAX_VALUE));
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}