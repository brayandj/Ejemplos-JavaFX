package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        MenuButton sites = new MenuButton("Sitios");
        MenuItem google = new MenuItem("Google");
        MenuItem youtube = new MenuItem("Youtube");
        google.setOnAction(actionEvent -> System.out.println("Google.com"));
        youtube.setOnAction(actionEvent -> System.out.println("Youtube.com"));
        sites.getItems().addAll(google, youtube);
        root.getChildren().addAll(sites);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control MenuButton");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
