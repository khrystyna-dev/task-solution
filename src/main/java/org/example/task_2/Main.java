package org.example.task_2;

import static org.example.task_2.AddOneToDigits.transform;

public class Main {
    public static void main(String[] args) {
        int input = 9989;
        int transformed = transform(input);
        System.out.println(transformed);
    }
}