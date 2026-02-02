package org.example.seleccionarregistrosvaloresnumericos;

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

    final private String url = "jdbc:mysql://localhost:3306/datos";
    final private String user = "root";
    final private String pass = "1234";
    Connection con;
    private ResultSet rs;
    @FXML
    private TextField salarioMinimo;
    @FXML
    private TextField salarioMaximo;
    @FXML
    private Button mostrarJasper;
    @FXML
    private Button mostrarJRXML;

    @FXML
    private void initialize(){

        try {
            con = DriverManager.getConnection(url, user, pass);

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "select * from datos.empleados";
            rs = statement.executeQuery(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void mostrarJaspre() throws JRException {


        HashMap<String, Object> parametro = new HashMap<>();
        parametro.put("min",salarioMinimo.getText());
        parametro.put("max",salarioMaximo.getText());
        String fileRepo = "Informes/InformeSalariosMaxMin.jasper";
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, parametro, con);
        JasperViewer viewer = new JasperViewer(jpRepo,false);
        viewer.setTitle("INFORME Jasper");
        viewer.setVisible(true);
    }

    @FXML
    protected void mostrarJrxml() throws JRException {



        JasperDesign d = JRXmlLoader.load("Informes/InformeSalariosMaxMin.jrxml");
        JRDesignQuery jq = new JRDesignQuery();
        jq.setText("SELECT * FROM datos.empleados where Salario BETWEEN " + salarioMinimo.getText() +" AND " + salarioMaximo.getText());
        d.setQuery(jq);
        JasperReport jr = JasperCompileManager.compileReport(d);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
        JasperViewer.viewReport(jp,false);
    }



}