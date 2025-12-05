package org.example.ejercicio6cambiarestilosmenubar;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu temas;

    @FXML
    private MenuItem estilos1;
    @FXML
    private MenuItem estilos2;
    @FXML
    private MenuItem quitarEstilos;

    @FXML
    private Button boton;

    @FXML
    private Label etiqueta;

    @FXML
    private AnchorPane panel;
    @FXML
    protected void initialize(){

    }
    @FXML
    protected void cambiarEstilos1(){
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("Estilo1.css").toExternalForm());
    }
    @FXML
    protected void cambiarEstilos2(){
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("Estilo2.css").toExternalForm());
    }
    @FXML
    protected void resetear(){
        panel.getStylesheets().clear();

    }


}