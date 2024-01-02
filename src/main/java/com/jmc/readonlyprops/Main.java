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
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);

        for (int row = 0; row <3; row++) {
            for (int col = 0; col < 3; col ++) {
                Button btn = new Button(col + "|" + row);
                root.add(btn, col, row);
            }
        }

        ColumnConstraints cc1 = new ColumnConstraints(100);
        ColumnConstraints cc2 = new ColumnConstraints(200);
        cc2.setHalignment(HPos.CENTER);
        ColumnConstraints cc3 = new ColumnConstraints(200);
        cc3.setHalignment(HPos.RIGHT);

        RowConstraints rc1 = new RowConstraints(50);
        rc1.setValignment(VPos.TOP);
        RowConstraints rc2 = new RowConstraints(70);
        RowConstraints rc3 = new RowConstraints(60);

        root.getColumnConstraints().addAll(cc1, cc2, cc3);
        root.getRowConstraints().addAll(rc1, rc2, rc3);

        root.setStyle("-fx-padding: 10");
        Scene scene = new Scene(root, 550, 350);
        stage.setScene(scene);
        stage.setTitle("Ejemplo layout GridPane");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
