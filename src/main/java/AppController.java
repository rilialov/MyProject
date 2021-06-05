import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AppController {
    private final Helper helper = new Helper();

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
    private void exit() {
        Platform.exit();
    }

    @FXML
    private void saveToCSV() {
        String path = chooseDirectory() + "\\form.csv";
        helper.saveToCSV(MainApp.getController(), path);
    }

    @FXML
    private void saveToXML() {
        String path = chooseDirectory() + "\\form.xml";
        Form form = new Form(getCourse(), getTrainer(), getDate(), getFirstName(), getLastName(), getPhone(), getEmail());
        helper.saveToXML(form, path);
    }

    @FXML
    private void loadFromXML() {
        FileChooser dialog = new FileChooser();
        dialog.setTitle("Выбор файла для сохранения..");
        dialog.setInitialDirectory(new File("C:\\"));
        dialog.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML файлы", "*.xml"));
        File result = dialog.showOpenDialog(MainApp.getWindow());
        if (result != null) {
            helper.readFromXML(result);
            Form form = helper.getForm();
            setCourse(form.getCourse());
            setTrainer(form.getTrainer());
            setDate(form.getDate());
            setFirstName(form.getFirstName());
            setLastName(form.getLastname());
        }
    }

    @FXML
    private void info() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("About");
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        try {
            stage.getIcons().add(new Image(new FileInputStream("C:\\Java\\icon.png")));
        } catch (FileNotFoundException e) {
            System.err.println("Error: problems with icon file loading");
        }
        dialog.setHeaderText("About this program");
        dialog.setContentText("This is program for practice");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.show();
    }

    public AppController() {
    }

    private void setCourse(String text) {
        course.setText(text);
    }

    private void setTrainer(String text) {
        trainer.setText(text);
    }

    private void setDate(String text) {
        date.setText(text);
    }

    private void setFirstName(String text) {
        firstName.setText(text);
    }

    private void setLastName(String text) {
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

    private String chooseDirectory () {
        DirectoryChooser dialog = new DirectoryChooser();
        dialog.setTitle("Выбор директории для сохранения..");
        dialog.setInitialDirectory(new File("C:\\"));
        File result = dialog.showDialog(MainApp.getWindow());
        return result.toString();
    }
}
