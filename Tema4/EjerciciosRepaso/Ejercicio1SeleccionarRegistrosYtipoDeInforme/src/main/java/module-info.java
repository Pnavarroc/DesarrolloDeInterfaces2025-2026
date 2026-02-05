module org.example.ejercicio1seleccionarregistrosytipodeinforme {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio1seleccionarregistrosytipodeinforme to javafx.fxml;
    exports org.example.ejercicio1seleccionarregistrosytipodeinforme;
}