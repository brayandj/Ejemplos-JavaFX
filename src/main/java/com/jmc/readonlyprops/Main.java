package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        HBox linksLaout = new HBox();
        linksLaout.setAlignment(Pos.CENTER);
        Hyperlink linkOne = new Hyperlink("GitHub");
        Hyperlink linkTwo = new Hyperlink("Udemy");
        WebView webView = new WebView();

        linkOne.setOnAction(actionEvent -> {
            webView.getEngine().load("https://github.com/");
        });
        linkTwo.setOnAction(actionEvent -> {
            webView.getEngine().load("https://www.udemy.com");
        });
        linksLaout.getChildren().addAll(linkOne, linkTwo);
        root.setTop(linksLaout);
        root.setCenter(webView);
        Scene scene = new Scene(root,500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de control Hyperlink");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
