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
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        ListView fruitList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Manzanas");
        items.add("Naranjas");
        items.add("Piñas");
        fruitList.setItems(items);
        //Top Nodos
        Label topLabel = new Label("Applicación de frutas");
        topLabel.setPadding(new Insets(20));
        //Right Nodos
        Label buttonLabel = new Label("Fruta añadida recientemente");
        buttonLabel.setPadding(new Insets(10));
        //Right Nodos
        Label rightLabel = new Label("Número total de tipos de fruta: " + fruitList.getItems().size());
        rightLabel.setRotate(90);
        rightLabel.setPadding(new Insets(0, 0, 0, 60));
        //Nodo Central
        TextField field = new TextField();
        Button button = new Button("Añadir");
        HBox centerContainer = new HBox(10, field, button);
        //Region ajustes BorderPane
        borderPane.setTop(topLabel);
        borderPane.setRight(rightLabel);
        borderPane.setBottom(buttonLabel);
        borderPane.setLeft(fruitList);
        borderPane.setCenter(centerContainer);
        //Registrar evento Handler
        button.setOnMouseClicked(mouseEvent -> {
            String item = field.getText();
            items.add(item);
            buttonLabel.setText("Fruta añadida recientemente: " + item);
            rightLabel.setText("Total de fruta");
            rightLabel.setText("Número total de tipos de fruta: " + fruitList.getItems().size());
            field.setText("");
            field.requestFocus();
        });
        Scene scene = new Scene(borderPane, 700, 650);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout de un BorderPane");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
