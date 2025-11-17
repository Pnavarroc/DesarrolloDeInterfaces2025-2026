module org.example.ejercicio14piezas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejercicio14piezas to javafx.fxml;
    exports org.example.ejercicio14piezas;
}