module org.example.ejerciciotablasautonomia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.ejerciciotablasautonomia to javafx.fxml;
    exports org.example.ejerciciotablasautonomia;
}