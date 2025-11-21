module org.example.ejercicio11listadoproductos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio11listadoproductos to javafx.fxml;
    exports org.example.ejercicio11listadoproductos;
}