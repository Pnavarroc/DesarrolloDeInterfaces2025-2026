package org.example.colorpiker1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class HelloController {

    @FXML
    private ColorPicker colorFondo;


    @FXML
    private ColorPicker colorLetra;

    @FXML
    private Button boton1;

    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    protected void cambiarFondos(){
        boton1.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));
        textField.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));
        label.setBackground(new Background(new BackgroundFill(colorFondo.getValue(), null, null)));

    }

    @FXML
    protected void cambiarLetra(){
        boton1.setTextFill(colorLetra.getValue());
        label.setTextFill(colorLetra.getValue());
    }


}