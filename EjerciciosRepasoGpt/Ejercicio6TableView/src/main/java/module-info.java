module org.example.ejercicio6tableview {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.ejercicio6tableview to javafx.fxml;
    exports org.example.ejercicio6tableview;
}
