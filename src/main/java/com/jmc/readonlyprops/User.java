package com.jmc.readonlyprops;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class User {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> birtDate;

    public User(String firstName, String lastName,LocalDate birDate) {
        this.firstName = new SimpleStringProperty(this, "firstName", firstName);
        this.lastName = new SimpleStringProperty(this, "lastName", lastName);
        this.birtDate = new SimpleObjectProperty<>(this, "birDate", birDate);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public LocalDate getBirDate() {
        return birtDate.get();
    }

    public ObjectProperty<LocalDate> birDateProperty() {
        return birtDate;
    }

    public void setFirtName(String newValue) {
        this.firstName.set(newValue);
    }

    public void setBirthDate(LocalDate newValue) {
        this.birtDate.set(newValue);
    }
}
