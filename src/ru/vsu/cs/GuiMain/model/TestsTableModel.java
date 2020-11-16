package ru.vsu.cs.GuiMain.model;

import ru.vsu.cs.GuiMain.data.DefaultTableData;

import javax.swing.table.DefaultTableModel;

public class TestsTableModel extends DefaultTableModel {

    public TestsTableModel() {
        super(DefaultTableData.testsData, DefaultTableData.tableHeader);
    }
}
