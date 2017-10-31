package my.tests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dmitriy on 26.10.2017.
 */
public class LifeForm {
    private JButton button1;
    private JPanel mainPanel;
    private JTable table1;

    public LifeForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hello world");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Life");
        frame.setContentPane(new LifeForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
