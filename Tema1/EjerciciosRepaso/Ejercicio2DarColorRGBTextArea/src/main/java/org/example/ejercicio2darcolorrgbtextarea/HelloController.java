package org.example.ejercicio2darcolorrgbtextarea;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private ComboBox<Integer> rojo;
    @FXML
    private ComboBox<Integer> verde;
    @FXML
    private ComboBox<Integer> azul;

    @FXML
    private TextField textField;

    @FXML
    protected void initialize(){
        rojo.setValue(0);
        verde.setValue(0);
        azul.setValue(0);
        for (int i = 0; i < 255; i++) {
            rojo.getItems().add(i);
            verde.getItems().add(i);
            azul.getItems().add(i);
        }

    }

    @FXML
    protected void CambiarColor(){
        // Ya que definimos los ComboBox<Integer>, getValue() devuelve Integer
        int r = rojo.getValue();
        int g = verde.getValue();
        int b = azul.getValue();

        textField.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b), null, null)));
    }
}