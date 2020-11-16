package ru.vsu.cs.GuiMain.controller;

import ru.vsu.cs.GuiMain.model.TestsTableModel;
import ru.vsu.cs.GuiMain.tests.Tests;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunTestsButtonController implements ActionListener {
    TestsTableModel testsTableModel;

    public RunTestsButtonController(TableModel testsTableModel) {
        this.testsTableModel = (TestsTableModel) testsTableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[][] tableData = readDataFromTableModel(this.testsTableModel);
        String[][] testResultsForJTable = Tests.getTestsResultsForJTable(tableData);
        if (testResultsForJTable != null) {
            writeDataToJTable(testsTableModel, testResultsForJTable);
        }
    }

    public static String[][] readDataFromTableModel(DefaultTableModel tableModel) {
        int rowCounts = tableModel.getRowCount();
        int colCount = tableModel.getColumnCount();
        String[][] tableData = new String[rowCounts][colCount];

        for (int row = 0; row < rowCounts; row++) {
            for (int col = 0; col < colCount; col++) {
                Object value = tableModel.getValueAt(row, col);
                if (value != null) {
                    tableData[row][col] = value.toString();
                }
                else {
                    tableData[row][col] = "";
                }
            }
        }
        return tableData;
    }

    public static void writeDataToJTable(TestsTableModel tableModel, String[][] arr) {
        int rowCounts = arr.length;
        int colCount = arr[0].length;
        tableModel.setRowCount(rowCounts);

        for (int row = 0; row < rowCounts; row++) {
            for (int col = 0; col < colCount; col++) {
                tableModel.setValueAt(arr[row][col], row, col);
            }
        }
    }
}
