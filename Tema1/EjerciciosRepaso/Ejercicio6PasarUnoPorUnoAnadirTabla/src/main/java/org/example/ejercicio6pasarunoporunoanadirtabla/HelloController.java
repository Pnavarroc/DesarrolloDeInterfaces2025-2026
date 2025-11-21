package org.example.ejercicio6pasarunoporunoanadirtabla;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class HelloController {
    //Para conectarnos a la base de datos:
    private static String URL= "jdbc:mysql://localhost:3306/datos";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";
    @FXML
    private Statement statement;
    @FXML
    Connection con;
    @FXML
    private ResultSet rs;


    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellidos;
    @FXML
    private TextField campoLocalidad;
    @FXML
    private TextField campoSalario;

    @FXML
    private TableView<Empleado> empleados;

    @FXML
    private TableColumn<Empleado,String> cNombre;
    @FXML
    private TableColumn<Empleado,String> cApellidos;
    @FXML
    private TableColumn<Empleado,String> cLocalidad;
    @FXML
    private TableColumn<Empleado,Integer> cSalario;

    @FXML
    private Button primero;
    @FXML
    private Button siguiente;
    @FXML
    private Button anterior;
    @FXML
    private Button ultimo;

    @FXML
    private Button nuevoRegistro;
    @FXML
    private Button guardar;

    @FXML
    private Button anadirAlaTabla;

    @FXML
    protected void initialize(){
        try{
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT * from datos.empleados";

            rs = statement.executeQuery(consulta);

            if (rs.next()){
                cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                cApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
                cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
                cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                /*Empleado empleado = new Empleado(
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Localidad"),
                        Integer.parseInt(rs.getString("Salario")));

                empleados.getItems().add(empleado);*/


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void ponerCamposVacios(){

        campoNombre.clear();
        campoApellidos.clear();
        campoLocalidad.clear();
        campoSalario.clear();
    }

    @FXML
    protected void ponerPrimeroRegistro(){
        try{
            if (rs.first()){
                campoNombre.setText(rs.getString("Nombre"));
                campoApellidos.setText(rs.getString("Apellidos"));
                campoLocalidad.setText(rs.getString("Localidad"));
                campoSalario.setText(rs.getString("Salario"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void ponerUltimoRegistro(){
        try{
            if (rs.last()){
                campoNombre.setText(rs.getString("Nombre"));
                campoApellidos.setText(rs.getString("Apellidos"));
                campoLocalidad.setText(rs.getString("Localidad"));
                campoSalario.setText(rs.getString("Salario"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlSiguiente(){
        try{
            if (rs.next()){
                campoNombre.setText(rs.getString("Nombre"));
                campoApellidos.setText(rs.getString("Apellidos"));
                campoLocalidad.setText(rs.getString("Localidad"));
                campoSalario.setText(rs.getString("Salario"));
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Es el ultimo registro");
                alert.setContentText("No puedes seguir hacia el siguiente campo porque no hay");
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlanterior(){
        try{
            if (rs.previous()){
                campoNombre.setText(rs.getString("Nombre"));
                campoApellidos.setText(rs.getString("Apellidos"));
                campoLocalidad.setText(rs.getString("Localidad"));
                campoSalario.setText(rs.getString("Salario"));
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Es el primer registro");
                alert.setContentText("No puedes seguir hacia el campo anterior porque no hay");
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void guardarEnBaseDeDatos(){

        try {
            String consulta= "INSERT INTO empleados VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(consulta);
            preparedStatement.setString(1,campoNombre.getText());
            preparedStatement.setString(2,campoApellidos.getText());
            preparedStatement.setString(3,campoLocalidad.getText());
            preparedStatement.setString(4, String.valueOf(Integer.parseInt(campoSalario.getText())));

            preparedStatement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Empleado guardado en la tabla");
            alert.setContentText("Bien hecho");
            alert.show();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void mostrarEnLaTableView(){

            cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
            cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                Empleado empleado = new Empleado(
                        campoNombre.getText(),
                        campoApellidos.getText(),
                        campoLocalidad.getText(),
                        Integer.parseInt(campoSalario.getText()));

                empleados.getItems().add(empleado);



    }

}