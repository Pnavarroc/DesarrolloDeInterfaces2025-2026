module org.example.examenrecuperacion1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.examenrecuperacion1 to javafx.fxml;
    exports org.example.examenrecuperacion1;
}