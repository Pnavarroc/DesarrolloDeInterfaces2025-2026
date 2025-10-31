module org.example.primervalidatorfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.controlsfx.controls;

    opens org.example.primervalidatorfx to javafx.fxml;
    exports org.example.primervalidatorfx;
}