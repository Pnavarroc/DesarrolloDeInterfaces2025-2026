module org.example.ejercicio3botones {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio3botones to javafx.fxml;
    exports org.example.ejercicio3botones;
}