module org.example.bbddtableview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.bbddtableview to javafx.fxml;
    exports org.example.bbddtableview;
}