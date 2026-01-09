module org.example.ejerciciotablabasico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.ejerciciotablabasico to javafx.fxml;
    exports org.example.ejerciciotablabasico;
}