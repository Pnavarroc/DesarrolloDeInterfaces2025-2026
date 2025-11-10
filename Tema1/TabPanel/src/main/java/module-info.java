module org.example.tabpanel {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tabpanel to javafx.fxml;
    exports org.example.tabpanel;
}