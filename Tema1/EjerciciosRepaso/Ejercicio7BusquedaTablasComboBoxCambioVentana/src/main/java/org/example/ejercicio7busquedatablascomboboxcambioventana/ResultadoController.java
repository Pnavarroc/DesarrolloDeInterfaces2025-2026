package org.example.ejercicio7busquedatablascomboboxcambioventana;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.List;

public class ResultadoController {
    @FXML
    private TableView<Empleado> tablaResultados;
    @FXML
    private TableColumn<Empleado, String> cNombre;
    @FXML
    private TableColumn<Empleado, String> cApellidos;
    @FXML
    private TableColumn<Empleado, String> cLocalidad;
    @FXML
    private TableColumn<Empleado, Integer> cSalario;

    public void initialize() {
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    }

    // Metodo para recibir los resultados desde la ventana principal
    public void cargarDatos(List<Empleado> lista) {
        tablaResultados.getItems().clear();
        tablaResultados.getItems().addAll(lista);
    }
}


