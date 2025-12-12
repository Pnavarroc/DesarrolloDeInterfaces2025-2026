module org.example.ejercicio10tablacambiopantalla {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio10tablacambiopantalla to javafx.fxml;
    exports org.example.ejercicio10tablacambiopantalla;
}