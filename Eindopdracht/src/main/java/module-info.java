module com.example.eindopdracht {
    requires javafx.controls;
    requires javafx.fxml;


    opens GUI to javafx.fxml;
    exports GUI;
}