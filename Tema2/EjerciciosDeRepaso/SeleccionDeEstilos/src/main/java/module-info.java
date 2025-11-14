module org.example.selecciondeestilos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.selecciondeestilos to javafx.fxml;
    exports org.example.selecciondeestilos;
}