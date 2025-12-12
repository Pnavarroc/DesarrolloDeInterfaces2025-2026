package org.example.ejercicio10tablacambiopantalla;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private TextField nombre;

    @FXML
    private ComboBox<String> comboCiudad;

    @FXML
    private CheckBox cbProgramacion;

    @FXML
    private CheckBox cbBasesDatos;

    @FXML
    private CheckBox cbInterfaces;


    @FXML
    private Button btnResumen;

    private List<Inscripcion> datos = new ArrayList<>();


    @FXML
    public void initialize() {
        //Rellenamos el comboBox
        comboCiudad.getItems().addAll(
                "Teruel",
                "Zaragoza",
                "Valencia"
        );


    }

    @FXML
    protected void añadirATabla() {
        //Miramos que esten todos los datos introducidos y si falta algo, sacamos un alert
        if (nombre.getText().isEmpty()
                || comboCiudad.getValue() == null
                || (!cbProgramacion.isSelected()
                && !cbBasesDatos.isSelected()
                && !cbInterfaces.isSelected())) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Rellena todos los campos");
            alert.show();
            return;
        }

        String nombreAlumno = nombre.getText();
        String ciudad = comboCiudad.getValue();

        String modulos = "";

        if (cbProgramacion.isSelected()) {
            modulos += "Programación, ";
        }
        if (cbBasesDatos.isSelected()) {
            modulos += "Bases de Datos, ";
        }
        if (cbInterfaces.isSelected()) {
            modulos += "Interfaces ";
        }




        Inscripcion inscripcion = new Inscripcion(nombreAlumno, ciudad, modulos);
        datos.add(inscripcion);



        // limpiar
        nombre.clear();
        comboCiudad.setValue(null);
        cbProgramacion.setSelected(false);
        cbBasesDatos.setSelected(false);
        cbInterfaces.setSelected(false);
    }

    //Cambio de pantalla
    @FXML
    protected void irResumen() throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("pantalla2.fxml")
        );

        Parent root = loader.load();

        Pantalla2Controller controller2 = loader.getController();
        controller2.setDatos(datos);

        Stage stage = (Stage) btnResumen.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}