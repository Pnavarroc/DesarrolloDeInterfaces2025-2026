module org.example.ejercicio1gridpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio1gridpane to javafx.fxml;
    exports org.example.ejercicio1gridpane;
}