package ru.vsu.cs;

import java.util.Arrays;

public class Logic {
    public static int getFirstIndexOfRepeatingSequence(int[] arr, int sequenceLength) {
        int startIndex = 0;
        int repeatCounter = 1;
        int arrLength = arr.length;

        for (int currentStartIndex = 0; currentStartIndex < arrLength - sequenceLength; currentStartIndex++) {
            int[] currentSequence = new int[sequenceLength];
            System.arraycopy(arr, currentStartIndex, currentSequence, 0, sequenceLength);
            int currentRepetitions = 1;

            for (int checkingIndex = currentStartIndex + sequenceLength;
                 checkingIndex < arrLength - (sequenceLength - 1);) {
                int[] checkingSequence = new int[sequenceLength];
                System.arraycopy(arr, checkingIndex, checkingSequence, 0, sequenceLength);

                if (Arrays.equals(currentSequence, checkingSequence)) {
                    currentRepetitions++;
                    checkingIndex += sequenceLength;
                }
                else {
                    checkingIndex++;
                }
            }

            if (currentRepetitions > repeatCounter) {
                repeatCounter = currentRepetitions;
                startIndex = currentStartIndex;
            }
        }
        return startIndex;
    }
}
