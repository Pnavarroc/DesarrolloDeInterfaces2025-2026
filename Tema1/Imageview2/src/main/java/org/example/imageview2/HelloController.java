package org.example.imageview2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
   @FXML
    private ComboBox elegir;


    @FXML
    private ImageView foto;

    @FXML
    protected void initialize(){
        elegir.getItems().addAll("Perro","Gato");

    }

    @FXML
    protected void cambiarFoto(){
        if (elegir.getValue().equals("Perro")){
            Image perro = new Image(getClass().getResource("img/perro.jpg").toExternalForm());
            foto.setImage(perro);
        }else if (elegir.getValue().equals("Gato")){
            Image gato = new Image(getClass().getResource("img/gato.jpg").toExternalForm());
            foto.setImage(gato);
        }


    }


}