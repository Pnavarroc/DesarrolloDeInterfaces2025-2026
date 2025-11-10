module org.example.evaluacioninicial {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.evaluacioninicial to javafx.fxml;
    exports org.example.evaluacioninicial;
}