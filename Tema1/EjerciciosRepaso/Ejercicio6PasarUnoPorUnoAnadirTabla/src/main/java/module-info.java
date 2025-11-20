module org.example.ejercicio6pasarunoporunoanadirtabla {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejercicio6pasarunoporunoanadirtabla to javafx.fxml;
    exports org.example.ejercicio6pasarunoporunoanadirtabla;
}