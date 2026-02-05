package org.example.ejercicio5seleccionintervalosnumericos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.HashMap;

public class HelloController {
    Connection con;
    private ResultSet rs;

    @FXML
    private TextField min;
    @FXML
    private TextField max;

    @FXML
    private Button mostrarJRXML;
    @FXML
    private Button mostrarJasper;

    @FXML
    private void initialize() {
        String url = "jdbc:mysql://localhost:3306/capitales";
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
    protected void mostrarInformeJasper() throws JRException {
        HashMap<String, Object> parametro = new HashMap<>();
        parametro.put("min",min.getText());
        parametro.put("max",max.getText());
        String fileRepo = "Informes/InformeCapitalesProvinciasRango.jasper";
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, parametro, con);
        JasperViewer viewer = new JasperViewer(jpRepo,false);
        viewer.setTitle("INFORME");
        viewer.setVisible(true);
    }

    @FXML
    private void mostrarInformeJRXML() throws JRException {
            HashMap<String, Object> parametro = new HashMap<>();
            parametro.put("min",min.getText());
            parametro.put("max",max.getText());
            JasperDesign d = JRXmlLoader.load("Informes/InformeCapitalesProvinciasRango.jrxml");
            JRDesignQuery jq = new JRDesignQuery();
            jq.setText("SELECT * FROM capitales.capitales where Población Between $P{min} AND $P{max}" );
            d.setQuery(jq);
            JasperReport jr = JasperCompileManager.compileReport(d);
            JasperPrint jp = JasperFillManager.fillReport(jr,parametro,con);
            JasperViewer.viewReport(jp,false);
        }
    }
