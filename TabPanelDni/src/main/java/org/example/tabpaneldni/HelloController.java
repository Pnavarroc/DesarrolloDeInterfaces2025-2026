package org.example.tabpaneldni;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField dni;
    @FXML
    private TextField fechaExpedicion;
    @FXML
    private Button informacion;
    @FXML
    private TextField consulta;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Button enviarMensaje;

    @FXML
    protected void initialize(){

    }
    @FXML
    protected void cambiarADni(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ayudadni.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();

    }


}