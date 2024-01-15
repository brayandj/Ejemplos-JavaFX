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
        Label selectedItemList = new Label("Primer selección en la lista");
        Button btnSelectedFirst = new Button("Primer item");
        ListView<String> list = new ListView<>();
        ObservableList<String> names = FXCollections.observableArrayList("Fernándo", "César", "Benjamín", "Gerardo", "Brayan", "Roxana");
        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> selectedItemList.setText("" + newValue));
        list.getItems().addAll(names);
        btnSelectedFirst.setOnAction(actionEvent -> list.getSelectionModel().selectFirst());
        root.getChildren().addAll(selectedItemList, list, btnSelectedFirst);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control ListView");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
