module org.example.ejercicio8rangeslider {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;


    opens org.example.ejercicio8rangeslider to javafx.fxml;
    exports org.example.ejercicio8rangeslider;
}