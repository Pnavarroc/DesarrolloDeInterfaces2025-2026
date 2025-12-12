module org.example.ejercicio3radioytogle {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejercicio3radioytogle to javafx.fxml;
    exports org.example.ejercicio3radioytogle;
}