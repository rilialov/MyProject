import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppController {
    private Helper helper = new Helper();

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
        helper.saveToCSV(MainApp.getController());
    }

    @FXML
    private void saveToXML() {
        Form form = new Form(getCourse(), getTrainer(), getDate(), getFirstName(), getLastName(), getPhone(), getEmail());
        helper.saveToXML(form);
    }

    @FXML
    private void loadFromXML() {
        helper.readFromXML();
        Form form = helper.getForm();
        setCourse(form.getCourse());
        setTrainer(form.getTrainer());
        setDate(form.getDate());
        setFirstName(form.getFirstName());
        setLastName(form.getLastname());
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
