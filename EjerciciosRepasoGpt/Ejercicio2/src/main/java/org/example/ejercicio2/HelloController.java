package org.example.ejercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class HelloController {
    @FXML
    private CheckBox java;
    @FXML
    private CheckBox pyhton;
    @FXML
    private CheckBox cplus;

    @FXML
    private Button enviar;

    @FXML
    private Label lenguajes;

    @FXML
    private AnchorPane panel;

    @FXML
    protected void mostrarMensaje(){
        String resultado = "Lenguajes seleccionados: ";
        boolean algunoSeleccionado = false;

        if (java.isSelected()) {
            resultado += java.getText() + " ";
            algunoSeleccionado = true;
        }
        if (pyhton.isSelected()) {
            resultado += pyhton.getText() + " ";
            algunoSeleccionado = true;
        }
        if (cplus.isSelected()) {
            resultado += cplus.getText() + " ";
            algunoSeleccionado = true;
        }

        if (!algunoSeleccionado) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Debes seleccionar al menos un lenguaje");
            alert.showAndWait();
        } else {
            lenguajes.setText(resultado);
        }
    }


}