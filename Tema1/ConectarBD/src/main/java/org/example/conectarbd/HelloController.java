package org.example.conectarbd;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class HelloController {
    private static String URL= "jdbc:mysql://localhost:3306/datos";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";
    @FXML
    private  ResultSet rs;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField localidad;

    @FXML
    private TextField salario;

    @FXML
    private Button primerRegistro;
    @FXML
    private Button izq;
    @FXML
    private Button der2;
    @FXML
    private Button ultimoRegistro;

    @FXML
    Connection con;
    @FXML
    private Button nuevoRegistro;

    @FXML
    private Button guardar;

    @FXML
    private Button añadirAlaTablaButton;

    @FXML
    private TableView<Empleado> tabla;

    @FXML
    private TableColumn<Empleado,String> cNombre;

    @FXML
    private TableColumn<Empleado,String> cApellidos;

    @FXML
    private TableColumn<Empleado,String> cLocalidad;

    @FXML
    private TableColumn<Empleado,Double> cSalario;



    @FXML
    protected void initialize(){

        try {
         con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT Nombre,Apellidos,Localidad,Salario from datos.empleados";


            rs = statement.executeQuery(consulta);

            if (rs.next()) {
                nombre.setText(rs.getString("Nombre"));
                apellidos.setText(rs.getString("Apellidos"));
                localidad.setText(rs.getString("Localidad"));
                salario.setText((rs.getString("Salario")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    protected void ponerCamposVacios(){
        nombre.clear();
        apellidos.clear();
        localidad.clear();
        salario.clear();

    }



    @FXML
    protected void pasarAlPrimerRegistro(){

        try {
            if (rs.first()) {
                nombre.setText(rs.getString("Nombre"));
                apellidos.setText(rs.getString("Apellidos"));
                localidad.setText(rs.getString("Localidad"));
                salario.setText((rs.getString("Salario")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    protected void pasarAlultimoRegistro(){
        try {
            if (rs.last()) {
                nombre.setText(rs.getString("Nombre"));
                apellidos.setText(rs.getString("Apellidos"));
                localidad.setText(rs.getString("Localidad"));
                salario.setText((rs.getString("Salario")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlaDerecha(){
        try {
            if (rs.next()) {
                nombre.setText(rs.getString("Nombre"));
                apellidos.setText(rs.getString("Apellidos"));
                localidad.setText(rs.getString("Localidad"));
                salario.setText((rs.getString("Salario")));
            }else  {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Eres tonto");
                alerta.setContentText("Eres un parguelon");
                alerta.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlaIquierda(){
        try {
            if (rs.previous()) {
                nombre.setText(rs.getString("Nombre"));
                apellidos.setText(rs.getString("Apellidos"));
                localidad.setText(rs.getString("Localidad"));
                salario.setText((rs.getString("Salario")));
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Eres tonto");
                alerta.setContentText("Eres un parguelon");
                alerta.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void guardarRegistro(){
        try {
            String meterdatos= "INSERT INTO empleados VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(meterdatos);
            preparedStatement.setString(1,nombre.getText());
            preparedStatement.setString(2,apellidos.getText());
            preparedStatement.setString(3,localidad.getText());
            preparedStatement.setInt(4,Integer.parseInt(salario.getText()));

            preparedStatement.executeUpdate();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Empleado guardado");
            alerta.setContentText("Eres un crack");
            alerta.show();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void anadirALaTabla(){

        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));

        Empleado empleados = new Empleado(nombre.getText(),apellidos.getText(),localidad.getText(),Double.parseDouble(salario.getText()));
        tabla.getItems().add(empleados);
    }



}