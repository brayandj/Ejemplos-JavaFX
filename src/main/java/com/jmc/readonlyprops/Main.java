package com.jmc.readonlyprops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        TreeView<String> treeView = new TreeView<>();
        TreeItem<String> classONe = new TreeItem<>("Class One");
        classONe.setExpanded(true);
        classONe.getChildren().addAll(
                new TreeItem<>("Inóngo"),
                new TreeItem<>("Negro"),
                new TreeItem<>("Firulais"),
                new TreeItem<>("Caracol")
        );
        TreeItem<String> classTwo = new TreeItem<>("Class Two");
        classTwo.setExpanded(true);
        classTwo.getChildren().addAll(
                new TreeItem<>("César"),
                new TreeItem<>("Gerarado"),
                new TreeItem<>("Fernándo"),
                new TreeItem<>("César")
        );
        classTwo.addEventHandler(TreeItem.branchExpandedEvent(),e -> System.out.println(e.getTreeItem().getValue()));
        TreeItem<String> classes = new TreeItem<>("Clasess");
        classes.getChildren().addAll(classONe, classTwo);
        treeView.setRoot(classes);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
        treeView.setCellFactory(tCell -> {
            TreeCell<String> cell = new TreeCell<>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(null);
                    setGraphic(null);
                    if (!empty) {
                        setText(item);
                        setGraphic(new Rectangle(15, 15, Color.GREEN));
                    }
                }
            };
            return  cell;
        });
        root.getChildren().addAll(treeView);
        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Ejemplo de un control TreeView parte 2");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
