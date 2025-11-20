module org.example.tappedpaneejercicio5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tappedpaneejercicio5 to javafx.fxml;
    exports org.example.tappedpaneejercicio5;
}