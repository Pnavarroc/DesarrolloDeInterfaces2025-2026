package org.example.ejercicio3informecontabla;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
    private Button mostarInformeTabla;

    @FXML
    protected void initialize(){
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
    protected void mostrarInformeJasper() throws JRException {


        String fileRepo = "Informes/InformeConTablaDatosEmpleados.jasper";
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, null, con);
        JasperViewer viewer = new JasperViewer(jpRepo,false);
        viewer.setTitle("INFORME Jasper");
        viewer.setVisible(true);
    }



}