module org.example.colorpiker2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.colorpiker2 to javafx.fxml;
    exports org.example.colorpiker2;
}