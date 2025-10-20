package org.example.bbddtableview;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class VentanaTabla {
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
    private TableView<Empleado> tableView;

    @FXML
    private TableColumn<Empleado,String> tNombre;

    @FXML
    private TableColumn<Empleado,String> tApellidos;

    @FXML
    private TableColumn<Empleado,String> tLocalidad;

    @FXML
    private TableColumn<Empleado,Double> tSalario;



    @FXML
    protected void initialize(){

        HelloController v =new HelloController();
        String localidad = String.valueOf(v.localidad);
        try {
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String consulta= "SELECT * from datos.empleados WHERE localidad LIKE '"+localidad+"'";


            rs = statement.executeQuery(consulta);

            while (rs.next()) {
                tNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                tApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
                tLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
                tSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                Empleado empleados = new Empleado(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("localidad"),Double.parseDouble(rs.getString("salario")));
                tableView.getItems().add(empleados);

                rs = statement.executeQuery("SELECT DISTINCT localidad FROM datos.empleados");




            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
