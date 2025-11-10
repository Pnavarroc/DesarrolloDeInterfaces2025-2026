module org.example.tabpaneldni {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tabpaneldni to javafx.fxml;
    exports org.example.tabpaneldni;
}