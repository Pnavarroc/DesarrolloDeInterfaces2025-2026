module org.example.conectarbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.conectarbd to javafx.fxml;
    exports org.example.conectarbd;
}