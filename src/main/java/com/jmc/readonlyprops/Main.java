package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    Label answer;
    CheckBox checkBox;
    @Override
    public void init() throws Exception {
        answer = new Label("Tu respuesta: None");
        checkBox = new CheckBox("Selecciónes");
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label question = new Label("Estás a favor?");
        checkBox.setAllowIndeterminate(true);
        checkBox.selectedProperty().addListener(this::changed);
        checkBox.indeterminateProperty().addListener(this::changed);

        root.getChildren().addAll(answer, question, checkBox);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control CheckBox");
        stage.show();
    }

    private void changed(ObservableValue<? extends Boolean> observableValue, Boolean olVal, Boolean newVal) {
        String choice;
        if (checkBox.isIndeterminate()) {
            choice = "Neutral";
        } else {
            choice = "En desacuerdo";
        }
        answer.setText("Tu respuesta: " + choice);
    }

    public static void main(String[] args) {
        launch();
    }
}
