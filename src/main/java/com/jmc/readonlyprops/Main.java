package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Haz click sobre el botón");
        Button button = new Button("Agregar");
        root.getChildren().addAll(label, button);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> label.setText("Has dado click sobre el botón"));
        Scene scene = new Scene(root, 550, 500);
        stage.setScene(scene);
        stage.setTitle("Evento click");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
