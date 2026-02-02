module org.example.seleccionarregistrosvaloresnumericos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.seleccionarregistrosvaloresnumericos to javafx.fxml;
    exports org.example.seleccionarregistrosvaloresnumericos;
}