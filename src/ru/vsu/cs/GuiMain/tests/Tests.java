package ru.vsu.cs.GuiMain.tests;

import ru.vsu.cs.GuiMain.data.CorrectData;
import ru.vsu.cs.GuiMain.logic.Logic;
import ru.vsu.cs.GuiMain.util.ArrayUtils;

import java.util.Arrays;

public class Tests {

    public static String[][] getTestsResultsForJTable(String[][] inputTestsData) {
        if (inputTestsData.length != 0) {
            String[][] testsResults = ArrayUtils.copy2DArr(inputTestsData);

            for (int line = 0; line < inputTestsData.length; line++) {
                int[] arr = ArrayUtils.toIntArray(inputTestsData[line][0]);

                int sequenceLen = Integer.parseInt(inputTestsData[line][1]);
                int startIndex = Logic.getFirstIndexOfRepeatingSequence(arr, sequenceLen);

                int[] sequence = new int[sequenceLen];
                System.arraycopy(arr, startIndex, sequence, 0, sequenceLen);

                testsResults[line][2] = Arrays.toString(sequence);
                testsResults[line][3] = Integer.toString(startIndex);
                testsResults[line][4] = Integer.toString(CorrectData.correctIndexes[line]);
                if (CorrectData.correctIndexes[line] == startIndex) {
                    testsResults[line][5] = "OK";
                }
                else {
                    testsResults[line][5] = "WRONG";
                }
            }
            return testsResults;
        }
        else {
            return null;
        }
    }
}
