package org.example.ejercicio4comboboxtextarea;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea textArea;

    @FXML
    private Button btn;

    @FXML
    protected void initialize(){
        comboBox.getItems().addAll("Madrid","Barcelona","Valencia","Zaragoza");
    }

    @FXML
    protected void enviar(){

        String valorSeleccionado = comboBox.getSelectionModel().getSelectedItem();

        if (valorSeleccionado == null) {
            textArea.appendText("No has seleccionado ninguna ciudad\n");
        } else {
            textArea.appendText("Has seleccionado: " + valorSeleccionado + "\n");
        }
    }

}