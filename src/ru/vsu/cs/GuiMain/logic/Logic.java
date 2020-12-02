package ru.vsu.cs.GuiMain.logic;

import java.util.Arrays;

public class Logic {
    public static int getFirstIndexOfRepeatingSequence(int[] arr, int sequenceLength) {
        int startIndex = 0;
        int repeatCounter = 1;

        for (int currentStartIndex = 0; currentStartIndex < arr.length - sequenceLength; currentStartIndex++) {
            int[] currentSequence = new int[sequenceLength];
            System.arraycopy(arr, currentStartIndex, currentSequence, 0, sequenceLength);
            int currentRepetitions = getCurrentRepetitions(currentStartIndex, arr, currentSequence);

            if (currentRepetitions > repeatCounter) {
                repeatCounter = currentRepetitions;
                startIndex = currentStartIndex;
            }
        }
        return startIndex;
    }

    private static int getCurrentRepetitions(int currentStartIndex, int[] arr, int[] currentSequence) {
        int currentRepetitions = 1;

        for (int checkingIndex = currentStartIndex + currentSequence.length;
             checkingIndex < arr.length - (currentSequence.length - 1);) {
            int[] checkingSequence = new int[currentSequence.length];
            System.arraycopy(arr, checkingIndex, checkingSequence, 0, currentSequence.length);

            if (Arrays.equals(currentSequence, checkingSequence)) {
                currentRepetitions++;
                checkingIndex += currentSequence.length;
            }
            else {
                checkingIndex++;
            }
        }
        return currentRepetitions;
    }
}
