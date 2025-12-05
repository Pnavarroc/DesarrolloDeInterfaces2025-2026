module org.example.calcularimc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.calcularimc to javafx.fxml;
    exports org.example.calcularimc;
}