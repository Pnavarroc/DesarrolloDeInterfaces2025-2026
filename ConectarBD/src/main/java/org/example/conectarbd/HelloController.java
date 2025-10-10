package org.example.conectarbd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
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
    protected void initialize(){

        try {
        Connection con = DriverManager.getConnection(URL,USUARIO,PASSWD);
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




}