module org.example.capitalesagrupadasporautonomia {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.capitalesagrupadasporautonomia to javafx.fxml;
    exports org.example.capitalesagrupadasporautonomia;
}