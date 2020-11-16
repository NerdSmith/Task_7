package ru.vsu.cs.GuiMain.view;

import ru.vsu.cs.GuiMain.controller.LineApplyButtonController;
import ru.vsu.cs.GuiMain.controller.RunTestsButtonController;
import ru.vsu.cs.GuiMain.controller.TableResizeController;
import ru.vsu.cs.GuiMain.model.TestsTableModel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel panelMain;
    private JTextField inputArrTextField;
    private JButton lineApplyButton;
    private JTextField indexResultTextField;
    private JTable testsTable;
    private JTextField resultSeqTextField;
    private JButton runTestsButton;
    private JTextField lenOfSearchingSeqTextField;

    public View() {
        super("Application");

        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1450, 400);
        this.setMinimumSize(new Dimension(500, 130));

        initJTable(testsTable);

        this.lineApplyButton.addActionListener(new LineApplyButtonController(inputArrTextField,
                lenOfSearchingSeqTextField, resultSeqTextField, indexResultTextField));

        this.runTestsButton.addActionListener(new RunTestsButtonController(this.testsTable.getModel()));

        this.setVisible(true);
    }

    private static void initJTable(JTable testsTable) {
        testsTable.setCellSelectionEnabled(true);
        testsTable.getTableHeader().setReorderingAllowed(false);
        testsTable.getTableHeader().setResizingAllowed(false);
        testsTable.setShowGrid(true);
        testsTable.setIntercellSpacing(new Dimension(1, 1));
        testsTable.setFillsViewportHeight(false);
        testsTable.setDragEnabled(false);
        testsTable.setModel(new TestsTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        testsTable.addComponentListener(new TableResizeController(testsTable.getColumnModel()));
    }
}
