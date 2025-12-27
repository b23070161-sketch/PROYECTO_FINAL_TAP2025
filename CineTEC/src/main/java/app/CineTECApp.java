package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CineTECApp extends Application {

    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            stage.setTitle("Inicio de sesion CineTEC ");


            stage.setWidth(450);
            stage.setHeight(550);
            stage.setResizable(false);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.err.println("ERROR AL CARGAR EL ARCHIVO FXML");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}