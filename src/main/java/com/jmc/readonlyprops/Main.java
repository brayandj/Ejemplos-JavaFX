package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        Rectangle rectangle = new Rectangle(300, 250);
        // Establecer el color de relleno del rectángulo-.L
        rectangle.setFill(Color.RED);
        Label label = new Label("Un rectangulo");
        StackPane.setAlignment(label, Pos.TOP_LEFT);
        pane.getChildren().addAll(rectangle, label);

        Scene scene = new Scene(pane, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout TackPane");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
