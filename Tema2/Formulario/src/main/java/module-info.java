module org.example.formulario {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.formulario to javafx.fxml;
    exports org.example.formulario;
}