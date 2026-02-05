package org.example.ejercicio1seleccionarregistrosytipodeinforme;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class HelloController {


    Connection con;
    private ResultSet rs;

    @FXML
    private ComboBox<String> localidades;

    @FXML
    private RadioButton agrupado;

    @FXML
    private RadioButton noAgrupado;


    @FXML
    private Button generarInformeJasper;
    @FXML
    private Button generarInformeJRXML;





    @FXML
    private void initialize(){
        String url = "jdbc:mysql://localhost:3306/datos";
        String user = "root";
        String pass = "1234";

        ToggleGroup agrupar = new ToggleGroup();
        agrupado.setToggleGroup(agrupar);
        noAgrupado.setToggleGroup(agrupar);

        try {
            con = DriverManager.getConnection(url, user, pass);

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT DISTINCT Localidad from datos.empleados";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                localidades.getItems().add(rs.getString("Localidad"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    private void generarInformeJXML() {
        String localidad = localidades.getValue();

        if (localidad == null) {
            System.out.println("Seleccione una localidad");
            return;
        }

        boolean esAgrupado = agrupado.isSelected();

        String jrxml;

        if (esAgrupado) {
            jrxml = "Informes/InformeSeleccionarRegistrosYtipodeInforme_agrupados.jrxml";
        } else {
            jrxml = "Informes/InformeSeleccionarRegistrosYtipodeInforme.jrxml";
        }

        // Preparado para Jrxml

        try {
            JasperDesign d = JRXmlLoader.load(jrxml);
            JRDesignQuery query = new JRDesignQuery();
            query.setText(
                    "SELECT Nombre, Apellidos, Localidad, Salario " +
                            "FROM datos.empleados WHERE Localidad = $P{loc}"
            );
            d.setQuery(query);

            JasperReport report = JasperCompileManager.compileReport(d);

            Map<String, Object> params = new HashMap<>();
            params.put("loc", localidad);

            JasperPrint print = JasperFillManager.fillReport(report, params, con);
            JasperViewer.viewReport(print, false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void generarInformeJasper() {
        String localidad = localidades.getValue();

        if (localidad == null) {
            System.out.println("Seleccione una localidad");
            return;
        }

        boolean esAgrupado = agrupado.isSelected();

        String jasper;

        if (esAgrupado) {
            jasper = "Informes/InformeSeleccionarRegistrosYtipodeInforme_agrupados.jasper";
        } else {
            jasper = "Informes/InformeSeleccionarRegistrosYtipodeInforme.jasper";
        }

        try {
            HashMap<String, Object> parametro = new HashMap<>();
            parametro.put("loc",localidad);
            String fileRepo = jasper;
            JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, parametro, con);
            JasperViewer viewer = new JasperViewer(jpRepo,false);
            viewer.setTitle("INFORME");
            viewer.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}