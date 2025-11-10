module org.example.validatorfx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires java.desktop;
    requires javafx.media;

    opens org.example.validatorfx2 to javafx.fxml;
    exports org.example.validatorfx2;
}