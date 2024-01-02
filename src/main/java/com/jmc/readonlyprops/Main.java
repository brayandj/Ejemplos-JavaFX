package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
        AnchorPane root = new AnchorPane();

        Button buttonRight = new Button("Boton derecho");
        Button topLeft = new Button("Top izquierda");
//        Ancla el botón "buttonRight" 10 píxeles arriba del borde inferior.
        AnchorPane.setBottomAnchor(buttonRight, 10.0);
//        Ancla el botón "buttonRight" 10 píxeles hacia adentro del borde derecho.
        AnchorPane.setRightAnchor(buttonRight, 10.0);

        AnchorPane.setTopAnchor(topLeft, 20.0);
        AnchorPane.setLeftAnchor(topLeft, 50.0);

        root.getChildren().addAll(topLeft, buttonRight);
        Scene scene = new Scene(root, 550, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout AnchorPane");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
