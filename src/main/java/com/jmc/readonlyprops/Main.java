package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        TabPane pane = new TabPane();
        Tab one = new Tab("Uno");
        Tab two = new Tab("Dos");
        VBox contentOne = new VBox();
        contentOne.setAlignment(Pos.CENTER);;
        contentOne.getChildren().addAll(new Label("Contenido para un Tab"));
        VBox contentTwo = new VBox();
        contentTwo.setAlignment(Pos.CENTER);;
        contentTwo.getChildren().addAll(new Button("Contenido Tab"));
        one.setContent(contentOne);
        two.setContent(contentTwo);
        pane.getTabs().addAll(one, two);
        root.setCenter(pane);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control TabPane");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
