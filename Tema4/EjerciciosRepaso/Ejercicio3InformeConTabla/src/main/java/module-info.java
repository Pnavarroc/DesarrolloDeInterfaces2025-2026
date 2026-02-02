module org.example.ejercicio3informecontabla {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio3informecontabla to javafx.fxml;
    exports org.example.ejercicio3informecontabla;
}