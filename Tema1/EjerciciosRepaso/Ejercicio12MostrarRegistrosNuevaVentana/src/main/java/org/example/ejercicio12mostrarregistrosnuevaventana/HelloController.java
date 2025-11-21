package org.example.ejercicio12mostrarregistrosnuevaventana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {

    private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static String USER = "root";
    private static String PASS = "1234";

    @FXML
    private TextField campoId;
    @FXML
    private TextField campoTitulo;
    @FXML
    private TextField campoAutor;
    @FXML
    private TextField campoISBN;
    @FXML
    private TextField campoPaginas;
    @FXML
    private TextField campoGenero;
    @FXML
    private TextField campoDisponible;

    @FXML private Button primero;
    @FXML private Button anterior;
    @FXML private Button siguiente;
    @FXML private Button ultimo;
    @FXML private Button mostrarGeneros;

    private Connection con;
    private Statement st;
    private ResultSet rs;

    @FXML
    protected void initialize() {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            rs = st.executeQuery("SELECT * FROM libros");

            if (rs.next()) {
                mostrarRegistroActual();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarRegistroActual() throws SQLException {
        campoId.setText(rs.getString("Id"));
        campoTitulo.setText(rs.getString("Titulo"));
        campoAutor.setText(rs.getString("Autor"));
        campoISBN.setText(rs.getString("ISBN"));
        campoPaginas.setText(rs.getString("Paginas"));
        campoGenero.setText(rs.getString("Genero"));
        campoDisponible.setText(rs.getString("Disponible"));
    }

    @FXML
    private void irPrimero() throws SQLException {
        if (rs.first()) {
            mostrarRegistroActual();
        }
    }

    @FXML
    private void irUltimo() throws SQLException {
        if (rs.last()) {
            mostrarRegistroActual();
        }
    }

    @FXML
    private void irSiguiente() throws SQLException {
        if (rs.next()) {
            mostrarRegistroActual();
        }
    }

    @FXML
    private void irAnterior() throws SQLException {
        if (rs.previous()) {
            mostrarRegistroActual();
        }
    }

    @FXML
    private void abrirVentanaGeneros() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("generos-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Listado de Géneros");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
