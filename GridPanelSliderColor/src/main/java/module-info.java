module org.example.gridpanelslidercolor {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gridpanelslidercolor to javafx.fxml;
    exports org.example.gridpanelslidercolor;
}