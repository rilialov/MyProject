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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {
    private static final Helper helper = new Helper();
    private static AppController controller;
    private static Window window;
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        logger.info("Starting application.");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("main.fxml"));
        AnchorPane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            logger.error("Failed to read fxml file.");
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
            logger.error("Failed to read icon file.");
        }
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.show();
        logger.info("Application started.");
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
