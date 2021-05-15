package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String name = "";
        System.out.println("Hello! What is your name?");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, " + name + "!");
    }
}
