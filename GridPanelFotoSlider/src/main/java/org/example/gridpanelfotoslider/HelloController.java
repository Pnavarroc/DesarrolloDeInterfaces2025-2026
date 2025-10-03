package org.example.gridpanelfotoslider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Slider slider;
    @FXML
    private ImageView perro;

    @FXML
    protected void initialize(){

        slider.setMax(perro.getFitHeight());

    }
    @FXML
    protected void cambiarTamaño(){
        perro.setFitHeight(slider.getValue());

    }
}