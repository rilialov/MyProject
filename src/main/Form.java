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
    private String firstname, lastname;
    private String phone, email;

    public Form() {
    }

    public Form(String course, String trainer, String date, String firstname, String lastname, String phone, String email) {
        this.course = course;
        this.trainer = trainer;
        this.date = date;
        this.firstname = firstname;
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

    public String getFirstName() {
        return firstname;
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