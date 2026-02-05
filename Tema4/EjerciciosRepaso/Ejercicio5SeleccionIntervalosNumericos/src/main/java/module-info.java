module org.example.ejercicio5seleccionintervalosnumericos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejercicio5seleccionintervalosnumericos to javafx.fxml;
    exports org.example.ejercicio5seleccionintervalosnumericos;
}