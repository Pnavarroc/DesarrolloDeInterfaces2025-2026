module org.example.colorpiker1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.colorpiker1 to javafx.fxml;
    exports org.example.colorpiker1;
}