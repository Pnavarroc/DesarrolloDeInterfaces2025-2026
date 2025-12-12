module org.example.ejercicio2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejercicio2 to javafx.fxml;
    exports org.example.ejercicio2;
}