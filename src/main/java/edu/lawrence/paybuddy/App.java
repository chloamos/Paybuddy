package edu.lawrence.paybuddy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        scene = new Scene(fxmlLoader.load(), 300, 200);
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        stage.setScene(scene);
        stage.setTitle("PayBuddy");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}