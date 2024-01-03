package com.jmc.readonlyprops;

import javafx.application.Application;
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

        Label label = new Label("Texto de prueba");
        Rectangle rectangle = new Rectangle(20, 20, Color.BLUE);
        label.setGraphic(rectangle);
        label.setUnderline(true);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        label.setTextFill(Color.GREEN);
        root.getChildren().addAll(label);
        Scene scene = new Scene(root,500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control Label");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
