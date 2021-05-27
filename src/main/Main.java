package main;

import java.io.*;
import java.util.Properties;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static FileReader FR;

    private static String name, lastname;
    private static String phone, email;
    private static String course, trainer, date;

    public static void main(String[] args) {
        getAnswers();
        loadProperties();
        print();
        close();
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
        System.out.printf("Your course - %s, trainer - %s, date - %s%n", course, trainer, date);
    }

    private static void loadProperties() {
        File file = new File("C:\\Java\\form_data.properties");
        Properties properties = new Properties();
        try {
            FR = new FileReader(file);
            properties.load(FR);
        } catch (IOException e) {
            System.err.println("Error: problems in loadProperties()");
        }
        course = properties.getProperty("course");
        trainer = properties.getProperty("trainer");
        date = properties.getProperty("date");
    }

    private static void close() {
        try {
            BR.close();
            FR.close();
        } catch (IOException e) {
            System.err.println("Error: problems in close()");
        }
    }
}
