package main;

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
}
