module org.example.examenprueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens org.example.examenprueba to javafx.fxml;
    exports org.example.examenprueba;
}