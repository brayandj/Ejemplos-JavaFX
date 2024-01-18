package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    Button startBtn = new Button("Comenzar");
    Button resetBtn = new Button("Reiniciar");
    Button cancelBtn = new Button("Cancelar");
    Button exitBtn = new Button("Salir");
    boolean onceStarted = false;

//    Service<ObservableList<Integer>> service = new Service<>() {
    ScheduledService<ObservableList<Integer>> service = new ScheduledService<>() {
        @Override
        protected Task<ObservableList<Integer>> createTask() {
            return new EvenNumTask(1, 20, 100);
        }
    };

    @Override
    public void start(Stage stage) {
        service.setPeriod(Duration.seconds(5));
        startBtn.setOnAction(e -> {
            if (onceStarted) {
                service.restart();
            } else {
                service.start();
                onceStarted = true;
                startBtn.setText("Restart");
            }
        });

        cancelBtn.setOnAction(e -> service.cancel());
        resetBtn.setOnAction(e -> service.reset());
        exitBtn.setOnAction(e -> Platform.exit());

        GridPane pane = new WorkerUI(service);
        HBox box = new HBox(5, startBtn, resetBtn, cancelBtn, exitBtn);
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(box);
        ;
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de Concurrencia en JavaFx");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
