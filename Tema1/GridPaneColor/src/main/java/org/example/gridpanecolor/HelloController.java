package org.example.gridpanecolor;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private ComboBox<Integer> rojo;

    @FXML
    private ComboBox<Integer> verde;

    @FXML
    private ComboBox<Integer> azul;

    @FXML
    private TextField color;

    @FXML
    protected void initialize(){
        rojo.setValue(0);
        verde.setValue(0);
        azul.setValue(0);
        for (int i = 0; i < 256; i++) {
            azul.getItems().add(i);
            verde.getItems().add(i);
            rojo.getItems().add(i);
        }



    }

    @FXML
    protected void CambiarColor(){
        color.setBackground(new Background(new BackgroundFill(Color.rgb(rojo.getValue(), verde.getValue(), azul.getValue()),null,null)));


    }
}