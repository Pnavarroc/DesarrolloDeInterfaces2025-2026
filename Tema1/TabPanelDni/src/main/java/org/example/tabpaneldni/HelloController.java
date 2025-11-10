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

import java.io.IOException;

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
    public void avisoLegal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventana-ayuda-2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage2= new Stage();
        stage2.setTitle("Aviso legal y politica de privacidad");
        stage2.setScene(scene2);
        stage2.show();
    }
    @FXML
    public void fechaExpedicion() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ayudadni.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage2= new Stage();
        stage2.setTitle("Fecha de Expedicion");
        stage2.setScene(scene2);
        stage2.show();
    }



}