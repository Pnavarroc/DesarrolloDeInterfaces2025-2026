package org.example.ejercicio12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.*;
public class HelloController {
Connection con;
private ResultSet rs;

/*@FXML
private ComboBox<String> categoria;*/
@FXML
private TextField cantidadVendidaMinima;
@FXML
private TextField cantidadVendidaMaxima;

//#,##0.00 €
/*@FXML
private Button mostrarJRXML;*/
@FXML
private Button mostrarJasper;

@FXML
private void initialize() {
    String url = "jdbc:mysql://localhost:3306/productos";
    String user = "root";
    String pass = "1234";

    try {
        con = DriverManager.getConnection(url, user, pass);

        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String sql = """
                        SELECT DISTINCT Categoría FROM ventas.ventas
                    """;
        rs = statement.executeQuery(sql);
       /* while (rs.next()){
            categoria.getItems().add(rs.getNString("Categoría"));
        }*/


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

        //String fileRepo = "informes/resentaciondeDatosProductos.jasper";
        InputStream reportStream =
                getClass().getResourceAsStream(
                        "/informes/resentaciondeDatosProductos.jasper"
                );
        JasperPrint jp = JasperFillManager.fillReport(reportStream, null, con);
        JasperViewer viewer = new JasperViewer(jp,false);
        viewer.setTitle("INFORME Campos Calculados");
        viewer.setVisible(true);

    }





}