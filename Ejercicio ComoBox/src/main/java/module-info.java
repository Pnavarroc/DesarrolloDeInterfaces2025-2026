module org.example.ejerciciocomobox {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejerciciocomobox to javafx.fxml;
    exports org.example.ejerciciocomobox;
}