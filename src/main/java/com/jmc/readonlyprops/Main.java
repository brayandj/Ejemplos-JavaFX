package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
//        Constant constant = new Constant(100);
//        constant.changeConstant();
//        System.out.println(constant.getReadOnlyNumber().get());
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        ObservableList<String> list = FXCollections.observableArrayList("one", "two", "three");
        ListView<String> items = new ListView<>();
        items.setItems(list);
        TextField field = new TextField();
        field.setMaxWidth(200);
        Button button = new Button("Agregar");
        button.setOnAction(actionEvent -> {
            if (!field.textProperty().get().isEmpty()) {
                list.add(field.getText());
                field.setText("");
                field.requestFocus();
            }
        });
        root.getChildren().addAll(items, field, button);
        Scene scene = new Scene(root, 550, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
