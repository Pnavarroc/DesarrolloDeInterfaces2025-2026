package org.example.bbddtableview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    private static String URL= "jdbc:mysql://localhost:3306/datos";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";
    @FXML
    private Statement statement;
    @FXML
    Connection con;
    @FXML
    private  ResultSet rs;
    @FXML
    TextField localidad;
    @FXML
    private Button mostrar;
    @FXML
    private TableView<Empleado> tableView;

    @FXML
    private TableColumn<Empleado,String> tNombre;

    @FXML
    private TableColumn<Empleado,String> tApellidos;

    @FXML
    private TableColumn<Empleado,String> tLocalidad;

    @FXML
    private TableColumn<Empleado,Double> tSalario;

    @FXML
    private ComboBox muestraLocalidades;


    @FXML
    protected void initialize(){

        try {
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT * from datos.empleados";


            rs = statement.executeQuery(consulta);

            while (rs.next()) {
                tNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                tApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
                tLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
                tSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                Empleado empleados = new Empleado(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("localidad"),Double.parseDouble(rs.getString("salario")));
                tableView.getItems().add(empleados);

                rs = statement.executeQuery("SELECT DISTINCT localidad FROM datos.empleados");

                while (rs.next()){
                    muestraLocalidades.getItems().add(rs.getString("localidad"));
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    protected void mostrarTablCombo(){

        try {
            tableView.getItems().clear();
            String consulta = "SELECT * FROM datos.empleados WHERE localidad LIKE '"+muestraLocalidades.getValue()+"'";
            rs= statement.executeQuery(consulta);

            while (rs.next()){
                tNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                tApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
                tLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
                tSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                Empleado empleados = new Empleado(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("localidad"),Double.parseDouble(rs.getString("salario")));
                tableView.getItems().add(empleados);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void mostrarEnLaTabla(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventana_tabla.fxml"));
        try {
            localidad.getText();
            Scene scene = new Scene(fxmlLoader.load(),600,600);
            Stage stage = new Stage();
            stage.setTitle("Mostrar localudades");
            stage.setScene(scene);

            stage.show();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}