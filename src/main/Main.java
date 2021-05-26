package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("Hello! What is your name?");
        String name = read();
        System.out.println("Hello, " + name + "!");
    }

    private static String read() {
        String s = "";
        try {
            s = BR.readLine();
        } catch (IOException e) {
            System.err.println("Error: problems in read()");
        }
        return s;
    }
}
