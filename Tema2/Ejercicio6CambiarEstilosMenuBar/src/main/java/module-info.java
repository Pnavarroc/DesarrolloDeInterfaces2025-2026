module org.example.ejercicio6cambiarestilosmenubar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio6cambiarestilosmenubar to javafx.fxml;
    exports org.example.ejercicio6cambiarestilosmenubar;
}