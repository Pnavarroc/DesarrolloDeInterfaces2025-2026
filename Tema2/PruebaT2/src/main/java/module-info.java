module org.example.pruebat2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pruebat2 to javafx.fxml;
    exports org.example.pruebat2;
}