package org.example.task_1;

import static org.example.task_1.RailFenceCipher.decode;
import static org.example.task_1.RailFenceCipher.encode;

public class Main {
    public static void main(String[] args) {
        String text = "WEAREDISCOVEREDFLEEATONCE";
        int rails = 3;

        String encodedText = encode(text, rails);
        System.out.println("Encoded text: " + encodedText);

        String decodedText = decode(encodedText, rails);
        System.out.println("Decoded text: " + decodedText);


        String text2 = "Hello, Vector!";
        int rails2 = 5;

        String encodedText2 = encode(text2, rails2);
        System.out.println("Encoded text: " + encodedText2);

        String decodedText2 = decode(encodedText2, rails2);
        System.out.println("Decoded text: " + decodedText2);
    }
}