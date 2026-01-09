package org.example.ejercicio10tablacambiopantalla;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Pantalla2Controller {
    @FXML
    private TableView<Inscripcion> tabla;   

    @FXML
    private TableColumn<Inscripcion, String> cNombre;
    @FXML
    private TableColumn<Inscripcion, String> cCiudad;
    @FXML
    private TableColumn<Inscripcion, String> cModulos;

    @FXML
    public void initialize() {
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        cModulos.setCellValueFactory(new PropertyValueFactory<>("modulos"));
    }

    public void setDatos(List<Inscripcion> lista) {
        tabla.getItems().addAll(lista);
    }
}
