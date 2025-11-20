module org.example.ejercicio3colorslider {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio3colorslider to javafx.fxml;
    exports org.example.ejercicio3colorslider;
}