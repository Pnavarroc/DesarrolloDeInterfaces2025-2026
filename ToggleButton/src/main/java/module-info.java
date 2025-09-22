module org.example.togglebutton {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.togglebutton to javafx.fxml;
    exports org.example.togglebutton;
}