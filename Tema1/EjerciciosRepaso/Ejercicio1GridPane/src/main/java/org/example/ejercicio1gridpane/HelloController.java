package org.example.ejercicio1gridpane;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private TextField nombrePaciente;

    @FXML
    private Button registrarCita;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Spinner hora;
    @FXML
    private Spinner minutos;

    @FXML
    private TextArea textArea;

    @FXML
    protected void initialize(){
        hora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17, 10, 1));
        //Esto lo que hace es, en el spinner
        // el primer numero es el minimo, el segundo el maximo el tercero el default y el ultimo de cuanto avanza
        minutos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 55, 0, 5));
    }

    @FXML
    protected void anadirCita(){
        DecimalFormat formatonumero = new DecimalFormat("00");//Formateamos la hora para que se pueda diferenciar si es por mla mañana o por la tarde

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Pasamos la fecha a dia mes año

        textArea.appendText("Nombre del paciente: "+nombrePaciente.getText()+"\n");
        textArea.appendText("Fecha de la cita: "+datePicker.getValue().format(formateador)+"\n");
        textArea.appendText("Hora de la cita: "+formatonumero.format(hora.getValue())+":"+formatonumero.format(minutos.getValue())+"\n");

    }

}