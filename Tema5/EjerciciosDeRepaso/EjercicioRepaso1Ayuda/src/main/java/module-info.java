module org.example.ejerciciorepaso1ayuda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.ejerciciorepaso1ayuda to javafx.fxml;
    exports org.example.ejerciciorepaso1ayuda;
}