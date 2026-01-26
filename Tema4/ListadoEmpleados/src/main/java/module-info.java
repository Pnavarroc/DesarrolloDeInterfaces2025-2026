module org.example.listadoempleados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.listadoempleados to javafx.fxml;
    exports org.example.listadoempleados;
}