module com.example.eindopdracht {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eindopdracht to javafx.fxml;
    exports com.example.eindopdracht;
}