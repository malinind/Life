package my.tests;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class LifeFrame extends JFrame {

    static int i = 0;

    public LifeFrame() {

        super("Тестовое окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i=0;i<10;i++) {
            Matrix matrix = new Matrix(30, 30);


            TableModel model = new MyTableModel(matrix);
            JTable table = new JTable(model) {
                @Override
                public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                    Component comp = super.prepareRenderer(renderer, row, column);
                    Object value = getModel().getValueAt(row, column);
                    //if (getSelectedRow() == row) {
                    if (value.equals(0)) {
                        comp.setBackground(Color.black);
                    } else if (value.equals(1)) {
                        comp.setBackground(Color.green);
                    } else {
                        comp.setBackground(Color.white);
                    }
                    //} else {
                    //    comp.setBackground(Color.white);
                    //}
                    return comp;
                }
            };


            getContentPane().add(new JScrollPane(table));

            setPreferredSize(new Dimension(500, 500));
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new LifeFrame();
            }
        });
    }




}