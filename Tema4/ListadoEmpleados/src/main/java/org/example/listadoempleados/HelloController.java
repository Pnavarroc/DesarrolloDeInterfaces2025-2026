package org.example.listadoempleados;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.HashMap;
import java.util.Objects;

public class HelloController {

    Connection con;
    private ResultSet rs;


    @FXML
    private Button  mostrarInformeJasper;
    @FXML
    private Button  mostrarInformeJrxm;
    @FXML
    private ComboBox<String> departamentos;


    @FXML
    private void initialize(){
        String url = "jdbc:mysql://localhost:3306/empresa";
        String user = "root";
        String pass = "1234";

        try {
            con = DriverManager.getConnection(url, user, pass);

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT departamento from departamentos";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                departamentos.getItems().add(rs.getString("departamento"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void mostrarInformeJrxml() throws JRException {
        JasperDesign d = JRXmlLoader.load("Informes/EmpresaEmpleados.jrxml"); //+ "' and población Between '" + valormin + "' and '" + valormax
        JRDesignQuery jq = new JRDesignQuery();
        jq.setText("SELECT e.nombre, e.fechanac, e.sexo, e.salario, d.departamento FROM empresa.empleados e JOIN empresa.departamentos d ON e.departamento=d.id");
        d.setQuery(jq);
        JasperReport jr = JasperCompileManager.compileReport(d);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
        JasperViewer.viewReport(jp,false);
    }



    @FXML
    protected void mostrarInformeJasper() throws JRException {
        HashMap<String, Object> param = new HashMap<>();
        param.put("depart",departamentos.getValue());
        String fileRepo = "Informes/EmpresaEmpleados.jasper";
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, param, con);
        JasperViewer viewer = new JasperViewer(jpRepo,false);
        viewer.setTitle("Informe Jasper");
        viewer.setVisible(true);
    }
}