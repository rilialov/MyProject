package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("main.fxml"));
        AnchorPane pane = loader.load();

        AppController controller = loader.getController();
        loadFromXML(controller);

        stage.setScene(new Scene(pane));
        stage.setTitle("Form");
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.show();
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
