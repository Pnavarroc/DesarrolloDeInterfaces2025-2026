package org.example.ejerciciocomobox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ComboBox provincias;

    @FXML
    private ComboBox instituto;

    @FXML
    private Button botonConfirmar;
    @FXML
    private TextField textoConfirmar;


    @FXML
    protected void initialize(){
        provincias.getItems().add("Zaragoza");
        provincias.getItems().add("Huesca");
        provincias.getItems().add("Teruel");

    }


    @FXML
    protected void confirmar(){
        textoConfirmar.setText(provincias.getValue().toString());
    }


    @FXML
    protected void mostarInstitutos(){
        instituto.getItems().clear();
        if (provincias.getValue().equals("Zaragoza")){
            instituto.getItems().add("Miguel Catalán");
            instituto.getItems().add("Arcosur");
        }else if (provincias.getValue().equals("Huesca")){

            instituto.getItems().add("Pirámide");
            instituto.getItems().add("Salesas");
        } else if (provincias.getValue().equals("Teruel")) {

            instituto.getItems().add("Segundo de Chomón");
            instituto.getItems().add("Vega del turia");
        }
    }


}


