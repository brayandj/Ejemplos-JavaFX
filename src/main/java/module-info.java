module com.jmc.readonlyprops {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.jmc.readonlyprops to javafx.fxml;
    exports com.jmc.readonlyprops;
}