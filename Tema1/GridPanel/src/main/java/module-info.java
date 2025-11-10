module org.example.gridpanel {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gridpanel to javafx.fxml;
    exports org.example.gridpanel;
}