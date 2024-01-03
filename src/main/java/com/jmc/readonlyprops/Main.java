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
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TextFlow root = new TextFlow();
        Text heading = new Text("Lorem ipsum");

        heading.setFill(Color.BLUE);
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        Text paramgraph = new Text("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ullam ea, esse eius quis quas quisquam dignissimos " +
                "dolorem vitae unde nihil sunt totam error pariatur quos obcaecati est consequuntur. Voluptatibus, itaque? " +
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ullam ea, esse eius quis quas quisquam dignissimos \" +\n" +
                "                \"dolorem vitae unde nihil sunt totam error pariatur quos obcaecati est consequuntur. Voluptatibus, itaque"
                );

        root.setLineSpacing(5);
        root.setTextAlignment(TextAlignment.CENTER);
        root.setPrefWidth(300);
        root.getChildren().addAll(heading, paramgraph);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout TextFlow");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
