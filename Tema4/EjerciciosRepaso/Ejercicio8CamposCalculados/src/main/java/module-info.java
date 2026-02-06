module org.example.ejercicio8camposcalculados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio8camposcalculados to javafx.fxml;
    exports org.example.ejercicio8camposcalculados;
}