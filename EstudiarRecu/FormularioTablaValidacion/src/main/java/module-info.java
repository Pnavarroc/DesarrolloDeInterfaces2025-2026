module org.example.formulariotablavalidacion {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.formulariotablavalidacion to javafx.fxml;
    exports org.example.formulariotablavalidacion;
}