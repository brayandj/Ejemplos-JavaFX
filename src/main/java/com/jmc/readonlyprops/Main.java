package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        ListView<Task> taskListView = new ListView<>();
        ObservableList<Task> tasks = FXCollections.observableArrayList(
                new Task("Crear proyecto Java"),
                new Task("Create reporte de compra"),
                new Task("Crear no sé que")
        );
        taskListView.setCellFactory(taskListView1 -> new CustomTaskCell());
        taskListView.getItems().addAll(tasks);
        root.getChildren().addAll(taskListView);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control ListView");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
