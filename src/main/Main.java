package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private static String name, lastname;
    private static String phone, email;

    public static void main(String[] args) {
        getAnswers();
        print();
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

    private static void getAnswers() {
        System.out.println("What is your name?");
        name = read();
        System.out.println("Your last name?");
        lastname = read();
        System.out.println("Phone number?");
        phone = read();
        System.out.println("E-mail?");
        email = read();
    }

    private static void print() {
        System.out.printf("Hello, %s %s! Nice to meet you!%n", lastname, name);
        System.out.printf("Your contacts: phone - %s, e-mail - %s%n", phone, email);
    }
}
