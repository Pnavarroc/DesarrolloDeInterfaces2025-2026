module org.example.examenpablonavarrocss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.examenpablonavarrocss to javafx.fxml;
    exports org.example.examenpablonavarrocss;
}