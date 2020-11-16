package ru.vsu.cs.model;

import ru.vsu.cs.data.DefaultTableData;

import javax.swing.table.DefaultTableModel;

public class TestsTableModel extends DefaultTableModel {

    public TestsTableModel() {
        super(DefaultTableData.testsData, DefaultTableData.tableHeader);
    }
}
