module org.example.ejercicio12mostrarregistrosnuevaventana {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejercicio12mostrarregistrosnuevaventana to javafx.fxml;
    exports org.example.ejercicio12mostrarregistrosnuevaventana;
}