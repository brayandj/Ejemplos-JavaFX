package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setFillWidth(true); //el VBox debe expandirse a todo lo ancho posible,  llenando el espacio horizontal de su nodo padre.
        TextArea textArea = new TextArea();
        VBox.setMargin(textArea, new Insets(0, 10, 0, 10));
        vBox.getChildren().add(textArea);
        Scene scene = new Scene(vBox, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout con un VBOX");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
