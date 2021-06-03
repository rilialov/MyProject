import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class MainApp extends Application {
    private static AppController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("main.fxml"));
        AnchorPane pane = loader.load();

        controller = loader.getController();
        loadFromXML(controller);

        stage.setScene(new Scene(pane));
        stage.setTitle("Form");
        stage.getIcons().add(new Image(new FileInputStream("C:\\Java\\icon.png")));
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.show();
    }

    static void saveToCSV(Helper helper) {
        helper.saveToCSV(controller);
    }

    private static void loadFromXML(AppController controller) {
        Helper helper = new Helper();
        helper.readFromXML();
        Form form = helper.getForm();
        controller.setCourse(form.getCourse());
        controller.setTrainer(form.getTrainer());
        controller.setDate(form.getDate());
        controller.setFirstName(form.getFirstName());
        controller.setLastName(form.getLastname());
    }
}
