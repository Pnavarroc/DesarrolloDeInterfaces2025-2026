package org.example.gridpanel;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private TextField nombre;
    @FXML
    private DatePicker fecha;

    @FXML
    private Button registrarCita;

    @FXML
    private Spinner hora;
    @FXML
    private Spinner minutos;

    @FXML
    private TextArea textArea;

    @FXML
    protected void initialize(){
        hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17, 8, 1));
        minutos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 0, 5));
    }

    @FXML
    protected void anadirCita(){


        DecimalFormat formatonumero = new DecimalFormat("00");

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        textArea.appendText("Nombre de paciente: "+nombre.getText() +"\n");
        textArea.appendText("Fecha de la cita: "+fecha.getValue().format(formateador)+"\n");
        textArea.appendText("Hora de la cita es: "+formatonumero.format(hora.getValue())+":"+formatonumero.format(minutos.getValue())+"\n");


    }



}