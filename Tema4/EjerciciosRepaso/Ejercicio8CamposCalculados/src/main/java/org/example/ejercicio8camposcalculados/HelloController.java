package org.example.ejercicio8camposcalculados;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;

public class HelloController {

    Connection con;
    private ResultSet rs;

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

            /*String sql = "SELECT * from datos.empleados";
            rs = statement.executeQuery(sql);*/


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void mostrarInformeJasper() throws JRException {

        /*HashMap<String, Object> param = new HashMap<>();
        param.put("min", Integer.parseInt(min.getText()));
        param.put("max", Integer.parseInt(max.getText()));

        InputStream imgStream =
                getClass().getResourceAsStream("/Imagenes/App1.png");
        param.put("foto", imgStream);*/

        String fileRepo = "Informes/InformeCampoCalculadoTotalVentasVentas.jasper";

        JasperPrint jp = JasperFillManager.fillReport(fileRepo, null, con);
        JasperViewer viewer = new JasperViewer(jp,false);
        viewer.setTitle("INFORME Campos Calculados");
        viewer.setVisible(true);

    }


    @FXML
    private void mostrarInformeJRXML() throws JRException {
       /* HashMap<String, Object> param = new HashMap<>();
        param.put("min", Integer.parseInt(min.getText()));
        param.put("max", Integer.parseInt(max.getText()));
        InputStream imgStream =
                getClass().getResourceAsStream("/Imagenes/App1.png");
        param.put("foto", imgStream);
        JasperDesign d = JRXmlLoader.load("Informes/InformeParametrosFotoGrafico.jrxml");
        JRDesignQuery jq = new JRDesignQuery();
        jq.setText("SELECT Provincia , Autonomía ,Población FROM capitales.capitales where Población Between $P{min} AND $P{max}");
        d.setQuery(jq);
        JasperReport jr = JasperCompileManager.compileReport(d);
        JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
        JasperViewer.viewReport(jp,false);*/

    }
}