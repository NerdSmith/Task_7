package ru.vsu.cs;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JTable tableInput;
    private JTable tableOutput;
    private JButton buttonExecute;
    private JButton buttonRandomInput;
    private JLabel labelResult;
    private JTextField textFieldLengthOfSequence;

    public FrameMain () {
        this.setTitle("Application");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, true, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 40, true, true, false, true);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);

        JTableUtils.writeArrayToJTable(tableInput, new int[]{0, 1, 2, 3, 4});

        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] matrix = ArrayUtils.createRandomIntMatrix(
                            tableInput.getRowCount(), tableInput.getColumnCount(), 100);
                    JTableUtils.writeArrayToJTable(tableInput, matrix);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableInput);
                    int[] arr;

                    if (matrix != null) {
                        arr = matrix[0];
                    }
                    else {
                        arr = new int[]{0, 1, 2, 3, 4};
                    }

                    String textOfLenSeqField = textFieldLengthOfSequence.getText();
                    int sequenceLength;

                    if (textOfLenSeqField.equals("")) {
                        sequenceLength = 1;
                    }
                    else {
                        sequenceLength = Integer.parseInt(textOfLenSeqField);
                    }

                    if (sequenceLength == 0) {
                        return;
                    }

                    int startIndex = Logic.getFirstIndexOfRepeatingSequence(arr, sequenceLength);
                    labelResult.setText("The first index of repeating sequence is: " + startIndex);

                    int[] sequence = new int[sequenceLength];

                    System.arraycopy(arr, startIndex, sequence, 0, sequenceLength);

                    if (matrix != null) {
                        matrix[0] = sequence;
                    }

                    JTableUtils.writeArrayToJTable(tableOutput, matrix);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
