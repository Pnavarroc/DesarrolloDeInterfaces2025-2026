package org.example.datepicker;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private DatePicker diaSeleccionado;

    @FXML
    private TextField textField;

    @FXML
    protected void initialize(){

    }
    @FXML
    protected void cambiarFecha(){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        textField.setText(diaSeleccionado.getValue().format(formateador));

    }


}