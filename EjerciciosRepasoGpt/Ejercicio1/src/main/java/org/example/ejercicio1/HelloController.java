package org.example.ejercicio1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;

    @FXML
    private Button enviar;

    @FXML
    private Label hola;

    @FXML
    private AnchorPane panel;

    @FXML
    protected void enviar(){
        if (nombre.getText().isEmpty()|| apellidos.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("FALTAN ELEMENTOS POR INTRODUCIR");
            alert.setContentText("Debes rellenar todos los campos");
            alert.show();
        }else {
            hola.setText("Hola, "+nombre.getText()+" "+apellidos.getText());
            nombre.setText("");
            apellidos.setText("");
        }
    }
}