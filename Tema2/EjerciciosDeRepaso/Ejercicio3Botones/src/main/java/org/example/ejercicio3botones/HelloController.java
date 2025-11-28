package org.example.ejercicio3botones;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private Button boton1;
    @FXML
    private Button boton2;
    @FXML
    private Button boton5;
    @FXML
    private Button boton7;
    @FXML
    private Button boton10;
    @FXML
    private Button boton15;
    @FXML
    private Button boton20;
    @FXML
    private Button boton25;
    @FXML
    private Button boton50;
    @FXML
    private Button boton60;
    @FXML
    private Button boton75;
    @FXML
    private Button boton100;
    @FXML
    AnchorPane anchorPane;

    @FXML
    TextField numeroAleatorio;

    @FXML
    TextField resultado;
    @FXML
    private Button newGame;

    Integer suma=0  ;
    Integer numero ;

    @FXML
    protected void initialize(){
        numero = (int) (Math.random() * 200) + 1;
        numeroAleatorio.setText(numero.toString());
        resultado.setText(suma.toString());

        boton1.setOnAction(e->{
            sumar(1);
            boton1.setDisable(true);
        });


        boton2.setOnAction(e->{
            sumar(2);
            boton2.setDisable(true);
        });
        boton5.setOnAction(e->{
            sumar(5);
            boton5.setDisable(true);
        });
        boton7.setOnAction(e->{
            sumar(7);
            boton7.setDisable(true);
        });
        boton10.setOnAction(e->{
            sumar(10);
            boton10.setDisable(true);
        });
        boton15.setOnAction(e->{
            sumar(15);
            boton15.setDisable(true);
        });
        boton20.setOnAction(e->{
            sumar(20);
            boton20.setDisable(true);
        });
        boton25.setOnAction(e->{
            sumar(25);
            boton25.setDisable(true);
        });
        boton50.setOnAction(e->{
            sumar(50);
            boton50.setDisable(true);
        });
        boton60.setOnAction(e->{
            sumar(60);
            boton60.setDisable(true);
        });
        boton75.setOnAction(e->{
            sumar(75);
            boton75.setDisable(true);
        });
        boton100.setOnAction(e->{
            sumar(100);
            boton100.setDisable(true);
        });





    }


    protected void sumar(Integer valor){
        suma+=valor;
        resultado.setText(suma.toString());
        if (resultado.getText().equals(numeroAleatorio.getText())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("HAS GANADOO!!!");
            alert.show();
        }

    }



    @FXML
    protected void nuevoJuego(){
        numero = (int) (Math.random() * 200) + 1;
        numeroAleatorio.setText(numero.toString());
        suma=0;
        resultado.setText(suma.toString());
        boton1.setDisable(false);
        boton2.setDisable(false);
        boton5.setDisable(false);
        boton7.setDisable(false);
        boton10.setDisable(false);
        boton15.setDisable(false);
        boton20.setDisable(false);
        boton25.setDisable(false);
        boton50.setDisable(false);
        boton60.setDisable(false);
        boton75.setDisable(false);
        boton100.setDisable(false);




    }

}