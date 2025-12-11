package org.example.ejerciciorepaso1ayuda;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private TextField resultado;

    @FXML
    private MenuItem pdf;

    @FXML
    private Button sumar;
    @FXML
    private Button restar;
    @FXML
    private Button multiplicar;

    @FXML
    protected void initialize(){

    }

    @FXML
    protected void sumar(){
        double n = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());

        double suma = n+n2;
        resultado.setText(String.valueOf(suma));

    }
    @FXML
    protected void restar(){
        double n = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());

        double suma = n-n2;
        resultado.setText(String.valueOf(suma));

    }
    @FXML
    protected void multiplicar(){
        double n = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());

        double suma = n*n2;
        resultado.setText(String.valueOf(suma));

    }

    @FXML
    protected void ayudaPdf(){
        try {
            Desktop.getDesktop().browse(new URI("EjerciciosRepasoT5Ej1.pdf"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void ayudaCHM(){
        try {
            Desktop.getDesktop().browse(new URI("EjerciciosRepasoT5Ej1.chm"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }



}