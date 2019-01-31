package com.personal.programmerMath.lesson3;

public class Lesson3_3 {
    public static boolean search(String[] dictionary, String wordToFind) {
        // illegal
        if (dictionary == null) {
            return false;
        }
        if (dictionary.length == 0) {
            return false;
        }

        int left = 0, right = dictionary.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (dictionary[middle].equals(wordToFind)) {
                return true;
            } else {
                if (dictionary[middle].compareTo(wordToFind) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
