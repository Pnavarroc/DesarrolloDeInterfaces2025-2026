package org.example.ejercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    TextField num1;
    @FXML
    TextField num2;
    @FXML
    TextField resultado;

    @FXML
    private void sumar(){
        Integer suma = Integer.valueOf(num1.getText()) +Integer.valueOf(num2.getText());
        resultado.setText(Integer.toString(suma));
    }
    @FXML
    private void restar(){
        Integer suma = Integer.valueOf(num1.getText()) -Integer.valueOf(num2.getText());
        resultado.setText(Integer.toString(suma));
    }
    @FXML
    private void multiplicar(){
        Integer suma = Integer.valueOf(num1.getText()) *Integer.valueOf(num2.getText());
        resultado.setText(Integer.toString(suma));
    }


}