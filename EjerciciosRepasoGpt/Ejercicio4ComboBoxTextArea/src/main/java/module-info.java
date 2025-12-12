module org.example.ejercicio4comboboxtextarea {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio4comboboxtextarea to javafx.fxml;
    exports org.example.ejercicio4comboboxtextarea;
}