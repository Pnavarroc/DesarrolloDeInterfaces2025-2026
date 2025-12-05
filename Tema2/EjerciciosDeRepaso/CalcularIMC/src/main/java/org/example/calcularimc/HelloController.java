package org.example.calcularimc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    private Label tituloPrincipal;

    @FXML
    private TextField peso;
    @FXML
    private TextField talla;
    @FXML
    private Button calcular;
    @FXML
    private Button cancelar;

    @FXML
    private Label textoResultado;
    @FXML
    private Label textoResultado2;

    @FXML
    private AnchorPane panel;

    @FXML
    private Button ayuda;

    @FXML
    protected void initialize(){

    }

    @FXML
    protected void calcularIMC(){

        double alturaEnMetros = Double.parseDouble(String.valueOf(talla.getText()))/100;

        double imc = Double.parseDouble(String.valueOf(peso.getText()))/(Math.pow(alturaEnMetros,2));

        if (imc < 18.5) {
            textoResultado2.setText("Bajo peso");
            textoResultado2.getStyleClass().add("bajo-peso");
        } else if (imc >= 18.5 && imc < 25.0) {
            textoResultado2.setText("Peso normal");
            textoResultado2.getStyleClass().add("peso-normal");
        } else if (imc >= 25.0 && imc < 30.0) {
            textoResultado2.setText("Sobrepeso");
            textoResultado2.getStyleClass().add("sobrepeso");
        } else if (imc >= 30.0 && imc < 40.0) {
            // Generalmente se clasifica Obesidad tipo I, II, III
            textoResultado2.setText("Obesidad (Clase I/II)");
            textoResultado2.getStyleClass().add("obesidad");
        } else {
            textoResultado2.setText("Obesidad (Clase III)");
            textoResultado2.getStyleClass().add("obesidad");
        }
        textoResultado.setText(String.valueOf(imc));



    }
    private void limpiarEstilos() {
        textoResultado2.getStyleClass().removeAll("bajo-peso", "peso-normal", "sobrepeso", "obesidad");
        textoResultado.setText(""); // Limpiamos el texto del IMC numérico también por si acaso
        textoResultado2.setText(""); // Limpiamos el texto del estado
    }
    @FXML
    protected void cancelar(){
        peso.clear();
        talla.clear();
        limpiarEstilos();

    }

    @FXML
    protected void ayuda(){
        try {
            Desktop.getDesktop().browse(new URI("AyudaIMC.chm"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}