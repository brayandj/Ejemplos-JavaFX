package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo FXML");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
