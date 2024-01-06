package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Collection;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label label = new Label("Tu selección");

        ChoiceBox<String> directions = new ChoiceBox<>();
        ObservableList<String> diriectionList = FXCollections.observableArrayList("Norte", "Sur", "Este", "Oeste");
        directions.getItems().addAll(diriectionList);
        directions.getSelectionModel().selectNext();
        directions.getSelectionModel().selectedIndexProperty().addListener(observable -> label.setText("Tu rirección: " +
                directions.getSelectionModel().getSelectedItem()));

        root.getChildren().addAll(label, directions);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control ChoiceBox");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
