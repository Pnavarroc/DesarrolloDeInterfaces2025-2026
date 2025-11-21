package org.example.ejercicio12mostrarregistrosnuevaventana;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class GenerosController {
    @FXML
    private TableView<Genero> tablaGeneros;
    @FXML
    private TableColumn<Genero, Integer> cId;
    @FXML
    private TableColumn<Genero, String> cNombre;

    private Connection con;
    private Statement st;
    private ResultSet rs;

    @FXML
    public void initialize() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca",
                    "root",
                    "1234"
            );

            st = con.createStatement();

            cId.setCellValueFactory(new PropertyValueFactory<>("id"));
            cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            rs = st.executeQuery("SELECT * FROM genero");

            while (rs.next()) {
                tablaGeneros.getItems().add(
                        new Genero(
                                rs.getInt("Id"),
                                rs.getString("Nombre")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}