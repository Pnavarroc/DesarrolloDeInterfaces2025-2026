package org.example.datosempleadoscampocalculado;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.*;
import java.util.HashMap;

public class HelloController{

    Connection con;
    private ResultSet rs;

    @FXML
    private RadioButton normal;
    @FXML
    private RadioButton agrupado;
    @FXML
    private Button mostrar;
    @FXML
    private Button mostrarTabla;
    @FXML
    private TextField poblaMin;
    @FXML
    private TextField poblaMax;

    @FXML
    private Button mostrarInformeCampoCalculado;


    @FXML
    private void initialize(){
        String url = "jdbc:mysql://localhost:3306/datos";
        String user = "root";
        String pass = "1234";

        try {
            con = DriverManager.getConnection(url, user, pass);

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * from datos.empleados";
            rs = statement.executeQuery(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    protected void mostrarInformeCampoCalculado() throws JRException {
        JasperDesign d = JRXmlLoader.load("Informes/DatosEmpleadosCampoCalculado1.jrxml"); //+ "' and población Between '" + valormin + "' and '" + valormax
        JRDesignQuery jq = new JRDesignQuery();
        jq.setText("SELECT Nombre, Apellidos, Localidad , Salario, Salario*0.85 AS SalNeto FROM datos.empleados ");
        d.setQuery(jq);
        JasperReport jr = JasperCompileManager.compileReport(d);
        JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
        JasperViewer.viewReport(jp,false);
    }



    @FXML
    protected void mostrarTabla() throws JRException {
        HashMap<String, Object> parametro = new HashMap<>();
        parametro.put("Sel","Aragón");
        String fileRepo = "Informes/CapitalesEjercicioTabla.jasper";
        JasperPrint jpRepo = JasperFillManager.fillReport(fileRepo, parametro, con);
        JasperViewer viewer = new JasperViewer(jpRepo,false);
        viewer.setTitle("INFORME CON TABLA");
        viewer.setVisible(true);
    }

    @FXML
    private void setMostrar() throws JRException {

        /*double valormin = Double.parseDouble(poblaMin.getText());
        double valormax = Double.parseDouble(poblaMax.getText());
        if (normal.isSelected()){
            HashMap<String, Object> param = new HashMap<>();
            param.put("Ruta_imagen", "file:Images/Pezazul.png");
            JasperDesign d = JRXmlLoader.load("Informes/Informe_Capitales_SinOrdenar.jrxml"); //+ "' and población Between '" + valormin + "' and '" + valormax
            JRDesignQuery jq = new JRDesignQuery();
            jq.setText("SELECT * FROM capitales.capitales where autonomía = '" + autonomia.getValue() + "' and población Between '" + valormin + "' and '" + valormax + "';");
            d.setQuery(jq);
            JasperReport jr = JasperCompileManager.compileReport(d);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            JasperViewer.viewReport(jp,false);
        } else {
            HashMap<String, Object> param = new HashMap<>();
            param.put("Ruta_imagen", "file:Images/Pezazul.png");
            JasperDesign d = JRXmlLoader.load("Informes/Informe_Capitales.jrxml");
            JRDesignQuery jq = new JRDesignQuery();
            jq.setText("SELECT * FROM capitales.capitales where autonomía = '" + autonomia.getValue() + "' and población Between '" + valormin + "' and '" + valormax + "';");
            d.setQuery(jq);
            JasperReport jr = JasperCompileManager.compileReport(d);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            JasperViewer.viewReport(jp,false);
        }*/
    }
}