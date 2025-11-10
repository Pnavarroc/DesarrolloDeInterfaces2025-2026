module org.example.imageview2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.imageview2 to javafx.fxml;
    exports org.example.imageview2;
}