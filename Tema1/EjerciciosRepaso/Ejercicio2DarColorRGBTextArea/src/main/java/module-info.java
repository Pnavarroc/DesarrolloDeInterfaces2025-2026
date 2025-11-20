module org.example.ejercicio2darcolorrgbtextarea {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio2darcolorrgbtextarea to javafx.fxml;
    exports org.example.ejercicio2darcolorrgbtextarea;
}