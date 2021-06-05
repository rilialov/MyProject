import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;

public class MainApp extends Application {
    private static AppController controller;
    private static Window window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("main.fxml"));
        AnchorPane pane = loader.load();

        controller = loader.getController();

        stage.setScene(new Scene(pane));
        window = stage.getScene().getWindow();
        stage.setTitle("Form");
        stage.getIcons().add(new Image(new FileInputStream("C:\\Java\\icon.png")));
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
}
