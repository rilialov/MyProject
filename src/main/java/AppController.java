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

import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppController {
    private Window window = MainApp.getWindow();
    private final Helper helper = MainApp.getHelper();
    private final String USER_DIR = helper.getUSER_DIR();
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

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
        logger.info("Exit.");
        Platform.exit();
    }

    @FXML
    private void saveToCSV() {
        String dir = chooseDirectory();
        if (!dir.equals("")) {
            String path = dir + "\\form.csv";
            helper.saveToCSV(MainApp.getController(), path);
        }
    }

    @FXML
    private void saveToXML() {
        String dir = chooseDirectory();
        if (!dir.equals("")) {
            String path = dir + "\\form.xml";
            Form form = new Form(getCourse(), getTrainer(), getDate(), getFirstName(), getLastName(), getPhone(), getEmail());
            helper.saveToXML(form, path);
        }
    }

    @FXML
    private void loadFromXML() {
        FileChooser dialog = new FileChooser();
        dialog.setTitle("Choosing file..");
        dialog.setInitialDirectory(new File(USER_DIR));
        dialog.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML files", "*.xml"));
        File result = dialog.showOpenDialog(window);
        if (result != null) {
            helper.readFromXML(result);
            Form form = helper.getForm();
            if (form != null) {
                setCourse(form.getCourse());
                setTrainer(form.getTrainer());
                setDate(form.getDate());
                setFirstName(form.getFirstName());
                setLastName(form.getLastname());
            } else {
                logger.error("Incorrect document markup.");
            }
        }
    }

    @FXML
    private void info() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("About");
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        try {
            stage.getIcons().add(new Image(new FileInputStream(USER_DIR + "\\icon.png")));
        } catch (FileNotFoundException e) {
            logger.error("Failed to read icon file.");
        }
        dialog.setHeaderText("About this program");
        dialog.setContentText("This is program for practice");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.show();
    }

    private String chooseDirectory () {
        DirectoryChooser dialog = new DirectoryChooser();
        dialog.setTitle("Choosing directory..");
        dialog.setInitialDirectory(new File(USER_DIR));
        File result = dialog.showDialog(window);
        if (result != null) {
            return result.toString();
        } else return "";
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
}
