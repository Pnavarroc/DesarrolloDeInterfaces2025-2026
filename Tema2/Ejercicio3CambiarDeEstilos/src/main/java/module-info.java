module org.example.ejercicio3cambiardeestilos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio3cambiardeestilos to javafx.fxml;
    exports org.example.ejercicio3cambiardeestilos;
}