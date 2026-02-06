module org.example.ejercicio12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio12 to javafx.fxml;
    exports org.example.ejercicio12;
}