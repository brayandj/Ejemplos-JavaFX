package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Label date = new Label();
        DatePicker datePicker = new DatePicker();
        datePicker.setEditable(true);
        datePicker.setOnAction(actionEvent -> date.setText(datePicker.getValue().toString()));
        root.getChildren().addAll(date, datePicker);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control DatePicker");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
