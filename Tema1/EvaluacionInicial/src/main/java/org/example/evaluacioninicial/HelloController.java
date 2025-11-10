package org.example.evaluacioninicial;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField pelicula;

    @FXML
    private Button anadir;

    @FXML
    private ComboBox comboBox;

    @FXML
    private Label label;

    @FXML
    private Button saludar;
    @FXML
    private Button noSaludar;




    @FXML
    protected void initialize(){
        label.setVisible(false);

    }

    @FXML
    protected void agregarPeliculas(){


        comboBox.getItems().add(pelicula.getText());
        pelicula.clear();
    }

    @FXML
    protected void noSaludar(){
        label.setVisible(false);


    }
    @FXML
    protected void saludar(){
        label.setVisible(true);

    }







}