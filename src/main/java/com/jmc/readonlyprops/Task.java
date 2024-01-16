package com.jmc.readonlyprops;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;


public class Task {
    private final StringProperty task;

    public Task(String task) {
        this.task = new SimpleStringProperty(this, "task", task);
    }

    public String getTask() {
        return task.get();
    }

    public StringProperty getTaskProperty() {
        return this.task;
    }

    @Override
    public String toString() {
        return this.task.get();
    }
}