package org.example.formulariotablavalidacion;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField nombre;
    @FXML
    private TextField localidad;
    @FXML
    private TextField salario;
    @FXML
    private ComboBox<String> departamento;
    @FXML
    private Button enviar;

    @FXML
    private TableView<Empleado> empleados;

    @FXML
    private TableColumn<Empleado,String> cNombre;
    @FXML
    private TableColumn<Empleado,String> cLocalidad;
    @FXML
    private TableColumn<Empleado,Double> cSalario;
    @FXML
    private TableColumn<Empleado,String> cDepartamento;


    @FXML
    protected void initialize(){
        departamento.getItems().addAll("Administracion","Producción","Comercial");

        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));//nombre es como lo llamo en mi modelo
        cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        cDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
    }

    @FXML
    protected void enviar(){

        String nom = nombre.getText().trim();
        String loc = localidad.getText().trim();
        String salTXT = salario.getText().trim();
        String dep = departamento.getValue();

        //Recojo todos los campos y ahora miramos que no esten vacios y sean validos en el caso del salario.

        if (nom.isEmpty()){
            alerta("Nombre obligatorio");
            nombre.requestFocus();
            return;
        }
        if (loc.isEmpty()){
            alerta("Localidad obligatoria");
            localidad.requestFocus();
            return;
        }
        if (dep==null){
            alerta("Seleciona un departamento");
            localidad.requestFocus();
            return;
        }
        if (salTXT.isEmpty()){
            alerta("Salario es obligatorio");
            salario.requestFocus();
            return;
        }

        //Ahora validamos que el salario introducido sea correcto
        double sal;

        try{
            sal=Double.parseDouble(salTXT);
        }catch (NumberFormatException e){
            alerta("El salario introducido no es valido");
            salario.requestFocus();
            return;
        }

        //Metemos los datos a la tabla

        Empleado emp = new Empleado(nom,loc,sal,dep);
        empleados.getItems().addAll(emp);

        nombre.clear();
        salario.clear();
        localidad.clear();
        departamento.getSelectionModel().clearSelection();

    }

    private void alerta(String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

}