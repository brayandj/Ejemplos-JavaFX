package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(actionEvent -> root.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY))));
        root.getChildren().addAll(colorPicker);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control ColorPicker");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
