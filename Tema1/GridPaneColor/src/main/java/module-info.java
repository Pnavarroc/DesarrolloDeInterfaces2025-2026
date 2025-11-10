module org.example.gridpanecolor {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gridpanecolor to javafx.fxml;
    exports org.example.gridpanecolor;
}