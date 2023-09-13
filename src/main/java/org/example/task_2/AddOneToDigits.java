package org.example.task_2;

import org.example.task_2.exception.InvalidInputException;

public class AddOneToDigits {
    private final static int MAX_VALUE = 1_036_372_536;
    public static int transform(int num) {
        checkInput(num);
        int transformed = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 9) {
                transformed += 10 * multiplier; // Insert 10 for each 9
            } else {
                transformed += (digit + 1) * multiplier; // Add 1 to the digit
            }

            num /= 10; // Move to the next digit
            multiplier *= (digit == 9) ? 100 : 10; // Update the multiplier accordingly
        }
        return transformed;
    }

    private static void checkInput(int num) {
        if (num < 0 || num > MAX_VALUE) {
            throw new InvalidInputException("Invalid input. Please enter the number from 0 to 1,036,372,536");
        }
    }
}