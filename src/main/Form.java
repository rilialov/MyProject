package main;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "form")
@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.FIELD)
public class Form {
    private String course, trainer, date;
    private String name, lastname;
    private String phone, email;

    public Form() {
    }

    public Form(String course, String trainer, String date, String name, String lastname, String phone, String email) {
        this.course = course;
        this.trainer = trainer;
        this.date = date;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}