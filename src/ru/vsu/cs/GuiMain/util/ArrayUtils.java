package ru.vsu.cs.GuiMain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ArrayUtils {
    /**
    * Использованы немного измененные методы от ДИ
    */
    public static int[] toIntArray(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,:;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        Integer[] arr = list.toArray(new Integer[0]);
        return toPrimitive(arr);
    }

    private static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static String[][] copy2DArr(String[][] arr) {
        if (arr == null) {
            return null;
        }
        String[][] arrCopy = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = new String[arr[i].length];
            System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[0].length);
        }
        return arrCopy;
    }
}
