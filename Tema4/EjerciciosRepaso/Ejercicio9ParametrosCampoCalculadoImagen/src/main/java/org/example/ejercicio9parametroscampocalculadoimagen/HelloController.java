package org.example.ejercicio9parametroscampocalculadoimagen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;

public class HelloController {
    Connection con;
    private ResultSet rs;

    @FXML
    private ComboBox<String> categoria;
    @FXML
    private TextField cantidadVendidaMinima;
    @FXML
    private TextField cantidadVendidaMaxima;

    //#,##0.00 €
    @FXML
    private Button mostrarJRXML;
    @FXML
    private Button mostrarJasper;

    @FXML
    private void initialize() {
        String url = "jdbc:mysql://localhost:3306/ventas";
        String user = "root";
        String pass = "1234";

        try {
            con = DriverManager.getConnection(url, user, pass);

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = """
                        SELECT DISTINCT Categoría FROM ventas.ventas
                    """;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                categoria.getItems().add(rs.getNString("Categoría"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void mostrarInformeJasperMinMax() throws JRException {

        HashMap<String, Object> param = new HashMap<>();
        param.put("min", Integer.parseInt(cantidadVendidaMinima.getText()));
        param.put("max", Integer.parseInt(cantidadVendidaMaxima.getText()));

        InputStream imgStream =
                getClass().getResourceAsStream("/Imagenes/Ventas.png");
        param.put("foto", imgStream);

        InputStream reportStream =
                getClass().getResourceAsStream(
                        "/Informes/InformeParametrosMinMaxVentas.jasper"
                );

        if (reportStream == null) {
            throw new RuntimeException("No se encuentra el informe MinMax");
        }

        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, con);
        JasperViewer.viewReport(jp, false);
    }



    @FXML
    private void mostrarInformeJasperCombo() throws JRException {

        HashMap<String, Object> param = new HashMap<>();
        param.put("cat", categoria.getValue());

        InputStream imgStream =
                getClass().getResourceAsStream("/Imagenes/Ventas.png");
        param.put("foto", imgStream);

        InputStream reportStream =
                getClass().getResourceAsStream(
                        "/Informes/InformeGraficoParam.jasper"
                );

        if (reportStream == null) {
            throw new RuntimeException("No se encuentra el informe Combo");
        }

        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, con);
        JasperViewer.viewReport(jp, false);
    }

}