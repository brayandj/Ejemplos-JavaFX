package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Button button = new Button("Haz click");
        Button otherButton = new Button("Otro Botón");
        Rectangle rectangle = new Rectangle(20, 20, Color.CYAN);
        otherButton.setGraphic(rectangle);
        button.setCancelButton(true);
        root.getChildren().addAll(otherButton, button);
        button.setOnAction(
                actionEvent -> {
                    System.out.println("Programa abandonado!");
                    Platform.exit();
                }
        );
        Scene scene = new Scene(root,500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control Label");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
