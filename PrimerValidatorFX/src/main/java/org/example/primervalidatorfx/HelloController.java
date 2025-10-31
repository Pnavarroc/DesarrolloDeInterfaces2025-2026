package org.example.primervalidatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.util.ArrayList;


public class HelloController {
    @FXML
    private TextField texto;
    @FXML
    private CheckBox checkBox;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button button;

    @FXML
    private ValidationSupport v = new ValidationSupport();
    @FXML
    protected void initialize(){
        v.registerValidator(texto , Validator.createEmptyValidator("Texto requerido"));
        v.registerValidator(checkBox,(Control c, Boolean newValue)-> ValidationResult.fromErrorIf(c,"CheckBox pulsado",!newValue));
        v.registerValidator(comboBox, Validator.createEmptyValidator("Elige una opcion"));
        v.setErrorDecorationEnabled(false);

        comboBox.getItems().addAll("Hola","Adios");

    }

    @FXML
    protected void mostrarErrores(){
        if (v.isInvalid()){
            v.setErrorDecorationEnabled(true);
        } else if (v.isInvalid()== false) {
            v.setErrorDecorationEnabled(false);
        }

    }


}