package org.example.gridpanelslidercolor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Slider rojo;
    @FXML
    private Slider verde;
    @FXML
    private Slider azul;
    @FXML
    private TextField color;


    @FXML
    protected void CambiarColor(){

        color.setBackground(new Background(new BackgroundFill(Color.rgb((int)rojo.getValue(),(int) verde.getValue(),(int) azul.getValue()),null,null)));;

    }
}