import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp extends Application {
    private static final Helper helper = new Helper();
    private static AppController controller;
    private static Window window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("main.fxml"));
        AnchorPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.err.println("Error: problems with fxml file loading");
        }

        controller = loader.getController();

        if (pane != null) {
            stage.setScene(new Scene(pane));
        }
        
        window = stage.getScene().getWindow();
        stage.setTitle("Form");
        try {
            stage.getIcons().add(new Image(new FileInputStream(helper.getUSER_DIR() + "\\icon.png")));
        } catch (FileNotFoundException e) {
            System.err.println("Error: problems with icon file loading");
        }
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.show();
    }

    public static AppController getController() {
        return controller;
    }

    public static Window getWindow() {
        return window;
    }

    public static Helper getHelper() {
        return helper;
    }
}
