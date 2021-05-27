package main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Properties;

public class Main {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static FileReader FR;

    private static String name, lastname;
    private static String phone, email;
    private static String course, trainer, date;
    private static Form form;

    private static final String XML_OUT = "C:\\Java\\form.xml";
    private static final String XML_IN = "C:\\Java\\info.xml";

    public static void main(String[] args) {
        System.out.println("Hello! Do you want to answer(a) questions or load from file(f)?");
        String s = read();
        switch (s) {
            case ("f") -> {
                readFromXML();
                print();
            }
            case ("a") -> {
                getAnswers();
                loadProperties();
                print();
                form = new Form(course, trainer, date, name, lastname, phone, email);
                saveToXML(form);
                close();
            }
            default -> System.out.println("bye!");
        }
    }

    private static String read() {
        String s = "";
        try {
            do {
                s = BR.readLine();
            } while(s.equals(""));
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

    private static void saveToXML(Form form) {
        try {
            JAXBContext context = JAXBContext.newInstance(Form.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File outFile = new File(XML_OUT);
            m.marshal(form, outFile);
        } catch (Exception e) {
            System.err.println("Error: problems in saveToXML()");
        }
    }

    private static void readFromXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            form = (Form) un.unmarshal(new File(XML_IN));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        course = form.getCourse();
        trainer = form.getTrainer();
        date = form.getDate();
        name = form.getName();
        lastname = form.getLastname();
        phone = form.getPhone();
        email = form.getEmail();
    }
}
