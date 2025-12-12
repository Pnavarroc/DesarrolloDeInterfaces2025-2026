package org.example.ejercicio3radioytogle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.nio.Buffer;

public class HelloController {
    @FXML
    private RadioButton hombre;
    @FXML
    private RadioButton mujer;
    @FXML
    private RadioButton otro;

    @FXML
    private Label texto;

    @FXML
    private Button btn;

    @FXML
    protected void initialize(){
        ToggleGroup toggleGroup = new ToggleGroup();
        hombre.setToggleGroup(toggleGroup);
        mujer.setToggleGroup(toggleGroup);
        otro.setToggleGroup(toggleGroup);
    }

    @FXML
    protected void pulsarAceptar(){
        if (hombre.isSelected()){
            texto.setText("Hola "+ hombre.getText());
        } else if (mujer.isSelected()) {
            texto.setText("Hola "+ mujer.getText());
        }else if (otro.isSelected()) {
            texto.setText("Hola "+ otro.getText());
        }
    }
}