package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Seccion de las estaciónes: ");
        ToggleButton spring = new ToggleButton("Primavera");
        ToggleButton summer = new ToggleButton("Verano");
        ToggleButton fall = new ToggleButton("Otoño");
        ToggleButton winter = new ToggleButton("Invierno");

        ToggleGroup seasons = new ToggleGroup();
        seasons.getToggles().addAll(spring, summer, fall, winter);
        HBox seasonsLayout = new HBox();
        seasonsLayout.setAlignment(Pos.CENTER);
        seasonsLayout.setSpacing(5);
        seasonsLayout.getChildren().addAll(spring, summer, fall, winter);
        root.getChildren().addAll(label, seasonsLayout);
        seasons.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
        label.setText("La selección de las cuatro estaciones es: " + ((Labeled)t1).getText());
        });
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control ToggleButton");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
