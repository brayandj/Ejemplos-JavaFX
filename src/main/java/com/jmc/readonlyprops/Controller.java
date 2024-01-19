package com.jmc.readonlyprops;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private IntegerProperty count = new SimpleIntegerProperty(0);
    @FXML
    public Label count_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        count_lbl.textProperty().bind(Bindings.concat("Count: ", count.asString()));

    }
    public void onevenincrement() {
        count.set(count.get()+1);
    }
}
