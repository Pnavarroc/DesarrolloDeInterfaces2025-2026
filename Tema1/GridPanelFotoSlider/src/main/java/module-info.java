module org.example.gridpanelfotoslider {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gridpanelfotoslider to javafx.fxml;
    exports org.example.gridpanelfotoslider;
}