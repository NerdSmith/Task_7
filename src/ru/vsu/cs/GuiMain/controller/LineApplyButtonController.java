package ru.vsu.cs.GuiMain.controller;

import ru.vsu.cs.GuiMain.logic.Logic;
import ru.vsu.cs.GuiMain.util.ArrayUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LineApplyButtonController implements ActionListener {

    JTextField inputArrTextField;
    JTextField lenOfSearchingSeqTextField;
    JTextField resultSeqTextField;
    JTextField indexResultTextField;

    public LineApplyButtonController(JTextField inputArrTextField, JTextField lenOfSearchingSeqTextField,
                                     JTextField resultSeqTextField, JTextField indexResultTextField) {
        this.inputArrTextField = inputArrTextField;
        this.lenOfSearchingSeqTextField = lenOfSearchingSeqTextField;
        this.resultSeqTextField = resultSeqTextField;
        this.indexResultTextField = indexResultTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputArrText = inputArrTextField.getText();
        String lenOfSearchingSeqText = lenOfSearchingSeqTextField.getText();

        if (inputArrText != null && !"".equals(inputArrText) &&
                lenOfSearchingSeqText != null && !"".equals(lenOfSearchingSeqText)) {
            int[] inputArr = ArrayUtils.toIntArray(inputArrText);
            int lenOfSearchingSeq = Integer.parseInt(lenOfSearchingSeqText);

            int startIndex = Logic.getFirstIndexOfRepeatingSequence(inputArr, lenOfSearchingSeq);
            int[] resultSequence = new int[lenOfSearchingSeq];
            System.arraycopy(inputArr, startIndex, resultSequence,0, lenOfSearchingSeq);

            this.indexResultTextField.setText(Integer.toString(startIndex));
            this.resultSeqTextField.setText(Arrays.toString(resultSequence));
        }
    }
}
