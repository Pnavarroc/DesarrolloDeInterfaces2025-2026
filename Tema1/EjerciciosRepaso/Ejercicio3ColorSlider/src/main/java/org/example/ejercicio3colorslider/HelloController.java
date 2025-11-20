package org.example.ejercicio3colorslider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView perro;
    @FXML
    private Slider sliderPerro;

    @FXML
    protected void initialize(){
        sliderPerro.setMax(perro.getFitHeight());//Le asignamos a la foto del perro su maximo
    }
    @FXML
    protected void cambiarColor(){

        color.setBackground(new Background(new BackgroundFill(Color.rgb((int)rojo.getValue(),(int)verde.getValue(),(int)azul.getValue()),null,null)));
    }
    @FXML
    protected void cambiarTamañoPerro(){
        perro.setFitHeight(sliderPerro.getValue());//Le asignamos a la foto el valor del slider
    }
}