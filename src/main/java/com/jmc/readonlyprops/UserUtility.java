package com.jmc.readonlyprops;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;


public class UserUtility {
    public static ObservableList<User> getUserList() {
        return FXCollections.observableArrayList(
                new User("El", "dia trás", LocalDate.of(1997, 10, 1)),
                new User("El", "dia lado", LocalDate.of(1990, 2, 10)),
                new User("El", "den frente", LocalDate.of(1987, 1, 11))
        );
    }
    public static TableColumn<User, String> getFirstNameColumn() {
            TableColumn<User, String> fNameCol = new TableColumn<>("Primer Nombre");
            fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            fNameCol.setSortable(false);
            return fNameCol;
        }

    public static TableColumn<User, String> getLastNameColumn() {
        TableColumn<User, String> lNameColumn = new TableColumn<>("Apellido");
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lNameColumn;
        }

    public static TableColumn<User, LocalDate> getNatDateColumn() {
        TableColumn<User, LocalDate> bDateCol = new TableColumn<>("Fecha Nacimiento");
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("birDate"));
        return bDateCol;
    }
    public static TableColumn<User, Button> getDeleteUserColumn() {
        TableColumn<User, Button> dUserCol = new TableColumn<>("Borrar");
        dUserCol.setCellFactory(col -> new TableCell<>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                setText(null);
                setGraphic(null);
                if (!empty) {
                    Button button = new Button("Eliminar");
                    button.setOnAction(actionEvent -> {
                        int rowIndex = this.getTableRow().getIndex();
                        this.getTableView().getItems().remove(rowIndex);
                    });
                    setText(null);
                    setGraphic(button);
                }
            }
        });
        return dUserCol;
        }
    }