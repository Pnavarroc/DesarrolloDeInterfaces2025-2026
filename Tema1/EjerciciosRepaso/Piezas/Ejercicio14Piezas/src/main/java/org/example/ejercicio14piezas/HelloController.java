package org.example.ejercicio14piezas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {

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
    private TextField campoNombre;
    @FXML
    private TextField campoPrecio;

    @FXML
    private Button anadirElemento;

    @FXML
    private Button mostrarTabla;

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

    }



    @FXML
    protected void guardarRegistro(){
        try {
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String meterdatos= "INSERT INTO piezas(Nombre, Precio) VALUES(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(meterdatos);
            preparedStatement.setString(1,campoNombre.getText());
            preparedStatement.setString(2, String.valueOf(Float.parseFloat(campoPrecio.getText())));

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void irAPagina() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pagina-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }








}