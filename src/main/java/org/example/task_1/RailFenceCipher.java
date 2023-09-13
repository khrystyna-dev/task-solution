package org.example.task_1;

import org.example.task_1.exception.InvalidRailFenceInputException;

public class RailFenceCipher {
    private final static String EMPTY_STRING = "";
    // Encode method to encrypt text using Rail Fence Cipher
    public static String encode(String text, int rails) {
        if (text.isEmpty()) {
            return EMPTY_STRING;
        }
        checkParams(text, rails);
        return process(text, rails, true);
    }

    // Decode method to decrypt text using Rail Fence Cipher
    public static String decode(String text, int rails) {
        if (text.isEmpty()) {
            return EMPTY_STRING;
        }
        checkParams(text, rails);
        return process(text, rails, false);
    }

    // Method to perform encoding or decoding based on the 'encode' parameter
    private static String process(String text, int rails, boolean encode) {
        int railLength = rails * 2 - 2; // Calculate the length of each "rail" in the rail fence
        int count = 0; // Initialize a count variable to keep track of the characters processed
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < rails; i++) {
            int index = i; // Initialize the index for the current rail
            int next = (i == rails - 1) ? railLength : (railLength - i * 2); // Calculate the next position

            while (index < text.length()) {
                if (encode) {
                    stringBuilder.setCharAt(count++, text.charAt(index)); // If encoding, add character to result
                }
                else {
                    stringBuilder.setCharAt(index, text.charAt(count++)); // If decoding, replace character in text
                }

                index += next; // Move to the next position

                if (next != railLength) {
                    next = railLength - next;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static void checkParams(String text, int rails) {
        if (rails <= 1 || rails >= text.length()) {
            throw new InvalidRailFenceInputException("Invalid 'rails' value. It must be greater "
                    + "than 1 and less than the text length.");
        }
    }
}