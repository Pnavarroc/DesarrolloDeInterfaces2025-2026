module org.example.alertas1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.alertas1 to javafx.fxml;
    exports org.example.alertas1;
}