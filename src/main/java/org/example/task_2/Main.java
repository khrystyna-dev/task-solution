package org.example.task_2;

import static org.example.task_2.AddOneToDigits.transform;

public class Main {
    public static void main(String[] args) {
        int input = 1036372537;
        int transformed = transform(input);
        System.out.println(transformed);
    }
}