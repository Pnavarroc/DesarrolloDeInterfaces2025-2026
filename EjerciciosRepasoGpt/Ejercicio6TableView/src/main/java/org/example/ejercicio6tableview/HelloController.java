package org.example.ejercicio6tableview;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class HelloController {


    @FXML private TextField nombre;
    @FXML private TextField edad;

    @FXML private RadioButton rbHombre;
    @FXML private RadioButton rbMujer;

    @FXML private ComboBox<String> comboLocalidad;
    @FXML private DatePicker fecha;

    @FXML private TableView<Persona> tabla;
    @FXML private TableColumn<Persona, String> cNombre;
    @FXML private TableColumn<Persona, Integer> cEdad;
    @FXML private TableColumn<Persona, String> cGenero;
    @FXML private TableColumn<Persona, String> cLocalidad;
    @FXML private TableColumn<Persona, LocalDate> cFecha;

    @FXML
    public void initialize() {

        //Iniciar la tabla
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        cGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        cFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        comboLocalidad.getItems().addAll("Teruel", "Zaragoza", "Valencia");
    }

    @FXML
    protected void enviarATabla() {

        if (nombre.getText().isEmpty()
                || edad.getText().isEmpty()
                || (!rbHombre.isSelected() && !rbMujer.isSelected())
                || comboLocalidad.getValue() == null
                || fecha.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Rellena todos los campos");
            alert.show();
            return;
        }

        int edadNum;
        try {
            edadNum = Integer.parseInt(edad.getText());
            if (edadNum < 0 || edadNum > 120) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Edad inválida (0-120)");
            alert.show();
            return;
        }

        String genero = rbHombre.isSelected() ? "Hombre" : "Mujer";
        String localidad = comboLocalidad.getValue();
        LocalDate fechaSeleccionada = fecha.getValue();

        Persona p = new Persona(nombre.getText(), edadNum, genero, localidad, fechaSeleccionada);

        tabla.getItems().add(p);

        // limpiar
        nombre.clear();
        edad.clear();
        rbHombre.setSelected(false);
        rbMujer.setSelected(false);
        comboLocalidad.setValue(null);
        fecha.setValue(null);
    }

}



