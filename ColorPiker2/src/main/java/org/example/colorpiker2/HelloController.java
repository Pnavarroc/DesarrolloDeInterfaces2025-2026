package org.example.colorpiker2;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;

import java.awt.*;

public class HelloController {
   @FXML
    private ComboBox tamañoLetra;
    @FXML
    private ColorPicker colorFondo;
    @FXML
    private ColorPicker colorTexto;

    @FXML
    private Label lorem;

    @FXML
    protected void cambiarFondo(){
        lorem.setBackground(new Background(new BackgroundFill
                (colorFondo.getValue(),null,null)));
    }

    @FXML
    protected void cambiarColorLetra(){
     lorem.setTextFill(colorTexto.getValue());
    }

    @FXML
    protected void cambiarTamaño(){
     int t = Integer.parseInt(tamañoLetra.getValue().toString());
     lorem.setFont(new Font(t));
    }

    @FXML
    protected void initialize(){

     for (int i = 8; i < 72; i++) {
      tamañoLetra.getItems().add(String.valueOf(i));
     }



    }





}