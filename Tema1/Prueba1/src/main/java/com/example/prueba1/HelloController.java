package com.example.prueba1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;
    @FXML
    private Button boton1;




    @FXML
    protected void Saludar(){
        textField2.setText("Hola "+textField1.getText());
    }

}