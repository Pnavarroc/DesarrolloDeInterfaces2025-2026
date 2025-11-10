module org.example.pruebajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.example.pruebajavafx to javafx.fxml;
    exports org.example.pruebajavafx;
}