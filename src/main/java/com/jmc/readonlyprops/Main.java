package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        TableView<User> userTable = new TableView<>(UserUtility.getUserList());
        userTable.setEditable(true);
        userTable.getColumns().addAll(
                UserUtility.getFirstNameColumn(),
                UserUtility.getLastNameColumn(),
                UserUtility.getNatDateColumn(),
                UserUtility.getDeleteUserColumn()
        );
        userTable.getSelectionModel().selectFirst();
        root.getChildren().addAll(userTable);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control ListView");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
