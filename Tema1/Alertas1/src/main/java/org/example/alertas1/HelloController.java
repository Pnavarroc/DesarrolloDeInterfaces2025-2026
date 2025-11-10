package org.example.alertas1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button informacionConEncabezado;
    @FXML
    private Button informacionSinEncabezado;
    @FXML
    private Button error;
    @FXML
    private Button confirmacion;

    @FXML
    protected void saltarInformacionConEncabezado(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Esta es el titulo de la alerta");
        alert.setHeaderText("Esto es el encabezado");
        alert.setContentText("Esto es el contenido");
        alert.show();
    }
    @FXML
    protected void saltarInformacionSinEncabezado(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Esta es el titulo de la alerta");
        alert.setContentText("Esto es el contenido");
        alert.show();
    }
    @FXML
    protected void saltarAlerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Esto es el contenido");
        alert.show();
    }
    @FXML
    protected void saltarConfirmacion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Esta es el titulo de la alerta");
        alert.setHeaderText("Esto es el encabezado");
        alert.setContentText("Esto es el contenido");
        alert.show();
    }
}