module com.jmc.readonlyprops {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jmc.readonlyprops to javafx.fxml;
    exports com.jmc.readonlyprops;
}