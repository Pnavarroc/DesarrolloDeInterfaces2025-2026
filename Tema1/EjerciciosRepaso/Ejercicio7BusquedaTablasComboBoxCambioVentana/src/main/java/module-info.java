module org.example.ejercicio7busquedatablascomboboxcambioventana {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejercicio7busquedatablascomboboxcambioventana to javafx.fxml;
    exports org.example.ejercicio7busquedatablascomboboxcambioventana;
}