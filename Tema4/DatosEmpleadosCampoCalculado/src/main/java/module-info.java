module org.example.datosempleadoscampocalculado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.datosempleadoscampocalculado to javafx.fxml;
    exports org.example.datosempleadoscampocalculado;
}