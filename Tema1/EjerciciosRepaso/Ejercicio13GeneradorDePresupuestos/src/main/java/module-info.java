module org.example.ejercicio13generadordepresupuestos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio13generadordepresupuestos to javafx.fxml;
    exports org.example.ejercicio13generadordepresupuestos;
}