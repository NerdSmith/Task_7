package ru.vsu.cs.GuiMain.controller;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TableResizeController extends ComponentAdapter {
    private final TableColumnModel columnModel;
    private final float[] columnWidthPercentage = {0.49f, 0.11f, 0.14f, 0.1f, 0.1f, 0.06f};

    public TableResizeController(TableColumnModel columnModel) {
        super();
        this.columnModel = columnModel;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resizeColumns();
    }

    private void resizeColumns() {
        int tableWidth = this.columnModel.getTotalColumnWidth();
        TableColumn column;
        int cantCols = this.columnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = this.columnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tableWidth);
            column.setPreferredWidth(pWidth);
        }
    }
}
