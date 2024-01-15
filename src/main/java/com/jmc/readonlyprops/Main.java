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
        MenuBar menu = new MenuBar();
        Menu file = new Menu("Archivo");
        MenuItem save = new MenuItem("Guardar");
        MenuItem exit = new MenuItem("Salir");
        exit.setOnAction(actionEvent -> Platform.exit());
        file.getItems().addAll(save, exit);

        Menu edit = new Menu("Edit");
        RadioMenuItem option = new RadioMenuItem("Opciones");
        RadioMenuItem settings = new RadioMenuItem("Configuración");
        MenuItem prefOne = new MenuItem("Pref: Uno");
        MenuItem prefTwo = new MenuItem("Pref: Dos");
        Menu prefs = new Menu("Preferencias");
        prefs.getItems().addAll(prefOne, prefTwo);
        edit.getItems().addAll(option, settings, new SeparatorMenuItem(), prefs);
        menu.getMenus().addAll(file, edit);
        root.setTop(menu);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control MenuBar");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
