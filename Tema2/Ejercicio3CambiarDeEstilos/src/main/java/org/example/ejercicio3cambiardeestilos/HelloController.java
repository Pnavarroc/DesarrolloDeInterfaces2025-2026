package org.example.ejercicio3cambiardeestilos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label titulo;

    @FXML
    private Button estilos1;

    @FXML
    private Button estilos2;
    @FXML
    private Button estilos3;

    @FXML
    private Button resetear;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    protected void cambiarEstilos1(){
        anchorPane.getStylesheets().clear();
        anchorPane.getStylesheets().add(getClass().getResource("estilos1.css").toExternalForm());
    }
    @FXML
    protected void cambiarEstilos2(){
        anchorPane.getStylesheets().clear();
        anchorPane.getStylesheets().add(getClass().getResource("estilos2.css").toExternalForm());
    }
    @FXML
    protected void cambiarEstilos3(){
        anchorPane.getStylesheets().clear();
        anchorPane.getStylesheets().add(getClass().getResource("estilos3.css").toExternalForm());
    }

    @FXML
    protected void resetear(){
        anchorPane.getStylesheets().clear();

    }

}