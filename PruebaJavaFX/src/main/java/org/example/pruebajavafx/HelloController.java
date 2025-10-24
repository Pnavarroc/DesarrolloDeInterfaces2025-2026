package org.example.pruebajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.SearchableComboBox;

import java.sql.*;

public class HelloController {

    private static String URL= "jdbc:mysql://localhost:3306/capitales";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";
    @FXML
    private Statement statement;
    @FXML
    Connection con;
    @FXML
    private ResultSet rs;

    @FXML
    private TableView<Capitales> tablaCapitales;

    @FXML
    private TableColumn<Capitales,String> tProvincia;

    @FXML
    private TableColumn<Capitales,String> tAutonomia;

    @FXML
    private TableColumn<Capitales,Integer> tPoblacion;
    @FXML
    private SearchableComboBox<String> searchableComboBox;



    @FXML
    protected void initialize(){

        try {
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT * from capitales.capitales";
            rs = statement.executeQuery(consulta);

            while (rs.next()) {
                tProvincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
                tAutonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
                tPoblacion.setCellValueFactory(new PropertyValueFactory<>("poblacion"));

               Capitales capitales = new Capitales(rs.getString("Provincia"),rs.getString("Autonomía"),
                       Integer.parseInt(rs.getString("Población")));
                tablaCapitales.getItems().add(capitales);

                searchableComboBox.getItems().add(capitales.getProvincia());



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    protected void mostrarTablCombo(){
        try {
            tablaCapitales.getItems().clear();
            String consulta = "SELECT * FROM capitales.capitales WHERE Provincia LIKE '"+searchableComboBox.getValue()+"'";
            rs= statement.executeQuery(consulta);

            while (rs.next()){
                tProvincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
                tAutonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
                tPoblacion.setCellValueFactory(new PropertyValueFactory<>("poblacion"));
                Capitales capitales = new Capitales(rs.getString("Provincia"),rs.getString("Autonomía")
                        , Integer.parseInt(rs.getString("Población")));
                tablaCapitales.getItems().add(capitales);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}