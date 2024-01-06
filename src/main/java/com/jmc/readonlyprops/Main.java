package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        ComboBox<String> names = new ComboBox<>();
        names.getItems().addAll("César", "Fernando", "Benjamín");
        names.setCellFactory(listView -> new ShapeNameCell());
        names.setButtonCell(new ShapeNameCell());
        root.getChildren().addAll(names);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control ComboBox");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
