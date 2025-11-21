package org.example.ejercicio8rangeslider;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.RangeSlider;

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
    private ResultSet rs;
    @FXML
    private TableView<Capital> capitales;
    @FXML
    private TableColumn<Capital,String> cProvincia;
    @FXML
    private TableColumn<Capital,String> cAutonomia;
    @FXML
    private TableColumn<Capital,Integer> cPoblacion;

    @FXML
    private RangeSlider rangeSlider;

    private int poblacionMin;
    private int poblacionMax;


    @FXML
    protected void initialize(){
        try{
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            // Configurar columnas solo una vez
            cProvincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
            cAutonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
            cPoblacion.setCellValueFactory(new PropertyValueFactory<>("poblacion"));


            cargarTodos();      // Cargar tabla completa

            obtenerPoblacionMinima();   // Consulta min
            obtenerPoblacionMaxima();   // Consulta max
            configurarRangeSlider();    // Slider configurado automáticamente



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarTodos() {
        try {
            capitales.getItems().clear();
            String consulta = "SELECT * FROM capitales.capitales";
            rs = statement.executeQuery(consulta);

            while (rs.next()) {
                Capital capital = new Capital(
                        rs.getString("Provincia"),
                        rs.getString("Autonomía"),
                        rs.getInt("Población")
                );

                capitales.getItems().add(capital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void obtenerPoblacionMinima(){

        try{
            String sql = "SELECT Población FROM capitales.capitales ORDER BY Población ASC LIMIT 1";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                poblacionMin = rs.getInt("Población");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void obtenerPoblacionMaxima() {
        try {
            String sql = "SELECT Población FROM capitales.capitales ORDER BY Población DESC LIMIT 1";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                poblacionMax = rs.getInt("Población");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void configurarRangeSlider() {

        rangeSlider.setMin(poblacionMin);
        rangeSlider.setMax(poblacionMax);

        // aquí pones los valores al máximo y mínimo reales
        rangeSlider.setLowValue(poblacionMin);
        rangeSlider.setHighValue(poblacionMax);

        rangeSlider.setShowTickMarks(true);
        rangeSlider.setShowTickLabels(true);
        rangeSlider.setMajorTickUnit(500000);
        rangeSlider.setMinorTickCount(0);
    }
    @FXML
    private void filtrar() {
        int min = (int) rangeSlider.getLowValue();   // valor mínimo actual del slider
        int max = (int) rangeSlider.getHighValue();  // valor máximo actual del slider

        capitales.getItems().clear();

        try {
            String sql = "SELECT * FROM capitales.capitales WHERE Población BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rsFiltrado = ps.executeQuery();

            while (rsFiltrado.next()) {
                Capital capital = new Capital(
                        rsFiltrado.getString("Provincia"),
                        rsFiltrado.getString("Autonomía"),
                        rsFiltrado.getInt("Población")
                );

                capitales.getItems().add(capital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}