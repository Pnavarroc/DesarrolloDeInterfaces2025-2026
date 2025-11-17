package org.example.ejercicio14piezas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Pagina2Controlador {
    private static String URL= "jdbc:mysql://localhost:3306/piezas";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";

    @FXML
    private Statement statement;
    @FXML
    Connection con;
    @FXML
    private ResultSet rs;

    @FXML
    private TableView tablaPiezas;

    @FXML
    private TableColumn tId;

    @FXML
    private TableColumn tNombre;

    @FXML
    private TableColumn tPrecio;


    @FXML
    protected void initialize(){
        try {
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT * from piezas.piezas";


            rs = statement.executeQuery(consulta);
            while (rs.next()) {
                tId.setCellValueFactory(new PropertyValueFactory<>("Id"));
                tNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
                tPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
                Piezas piezas = new Piezas(Integer.parseInt(rs.getString("Id")),rs.getString("nombre"),Float.parseFloat(rs.getString("precio")));
                tablaPiezas.getItems().add(piezas);


            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
