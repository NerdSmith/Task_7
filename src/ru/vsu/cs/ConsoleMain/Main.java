package ru.vsu.cs.ConsoleMain;

import ru.vsu.cs.ConsoleMain.util.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.readIntArrayFromConsole("");
        int sequenceLength = readVar("Enter length of searching sequence: ");
        int firstIndexOfRepeatingSequence = getFirstIndexOfRepeatingSequence(arr, sequenceLength);
        System.out.printf("Index of the first element is: %d", firstIndexOfRepeatingSequence);
    }

    public static int readVar(String phrase) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s", phrase);
        return scanner.nextInt();
    }

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
