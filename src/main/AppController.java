package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private TextField course;

    @FXML
    private TextField trainer;

    @FXML
    private TextField date;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private void saveAndExit() {
        Helper helper = new Helper();
        Form form = new Form(getCourse(), getTrainer(), getDate(), getFirstName(), getLastName(), getPhone(), getEmail());
        helper.saveToXML(form);
        Platform.exit();
    }

    public AppController() {

    }

    public void setCourse(String text) {
        course.setText(text);
    }

    public void setTrainer(String text) {
        trainer.setText(text);
    }

    public void setDate(String text) {
        date.setText(text);
    }

    public void setFirstName(String text) {
        firstName.setText(text);
    }

    public void setLastName(String text) {
        lastName.setText(text);
    }

    public String getCourse() {
        return course.getText();
    }

    public String getTrainer() {
        return trainer.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getEmail() {
        return email.getText();
    }
}
