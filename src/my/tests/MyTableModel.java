package my.tests;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmitriy on 27.10.2017.
 */
public class MyTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private Matrix matrix;

    public MyTableModel(Matrix matrix) {
        this.matrix = matrix;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 10;
    }

    public String getColumnName(int columnIndex) {

        return "0";
    }

    public int getRowCount() {
        return matrix.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cell cell = matrix.getCell(rowIndex,columnIndex);

        return cell.isAlive() ? 1:0;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}
