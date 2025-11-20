package org.example.tappedpaneejercicio5;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab datosConductor;
    @FXML
    private Tab tCoche;
    @FXML
    private Tab tMonovolumen;

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private CheckBox coche;

    @FXML
    private CheckBox monoVolumen;

    @FXML
    protected void initialize(){
        tCoche.setDisable(true);
        tMonovolumen.setDisable(true);
    }
    @FXML
    protected void habilitarTab(){
        if (coche.isSelected()){
            tCoche.setDisable(false);
        }else if (!coche.isSelected()){
            tCoche.setDisable(true);
        }

        if (monoVolumen.isSelected()){
            tMonovolumen.setDisable(false);
        }else if (!monoVolumen.isSelected()){
            tMonovolumen.setDisable(true);
        }

    }

}