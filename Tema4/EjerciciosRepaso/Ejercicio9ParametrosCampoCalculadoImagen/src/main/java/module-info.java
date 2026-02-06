module org.example.ejercicio9parametroscampocalculadoimagen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio9parametroscampocalculadoimagen to javafx.fxml;
    exports org.example.ejercicio9parametroscampocalculadoimagen;
}