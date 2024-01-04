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
    Label userSelection;
    @Override
    public void init() throws Exception {
        userSelection = new Label("Nada seleccionado aún");
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        RadioButton spring = new RadioButton("Primavera");
        RadioButton summer = new RadioButton("Verano");
        RadioButton fall = new RadioButton("Otoño");
        RadioButton winter = new RadioButton("Invierno");

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(spring, summer, fall, winter);
        group.selectedToggleProperty().addListener(this::changed);
        root.getChildren().addAll(userSelection, spring, summer, fall, winter);
        
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control RadioButton");
        stage.show();
    }

    private void changed(ObservableValue<? extends Toggle> observable, Toggle oldBtn, Toggle newBtn) {
        String selectedLabel = "None";
        if (newBtn != null) {
            selectedLabel = ((Labeled)newBtn).getText();
        }
        userSelection.setText("Tu selección: " + selectedLabel);
    }

    public static void main(String[] args) {
        launch();
    }
}
