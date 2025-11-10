package org.example.tabpanel;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private CheckBox coche;
    @FXML
    private CheckBox monovolumen;

    @FXML
    private Tab datosConductor;
    @FXML
    private Tab pantallaCoche;
    @FXML
    private Tab pantallaMonovolumen;

    @FXML
    protected void initialize(){
        pantallaCoche.setDisable(true);
        pantallaMonovolumen.setDisable(true);

    }

    @FXML
    protected void oCocheOMonovolumen(){
        if (coche.isSelected()){
            pantallaCoche.setDisable(false);
        } else if (!coche.isSelected()) {
            pantallaCoche.setDisable(true);
        }
        if (monovolumen.isSelected()){
            pantallaMonovolumen.setDisable(false);
        } else if (!monovolumen.isSelected()) {
            pantallaMonovolumen.setDisable(true);
        }
    }
}