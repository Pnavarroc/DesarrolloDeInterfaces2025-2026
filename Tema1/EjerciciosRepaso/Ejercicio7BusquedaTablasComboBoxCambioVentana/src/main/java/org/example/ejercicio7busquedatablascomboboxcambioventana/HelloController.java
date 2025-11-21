package org.example.ejercicio7busquedatablascomboboxcambioventana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
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
    private TableView<Empleado> empleados;

    @FXML
    private TableColumn<Empleado,String> cNombre;
    @FXML
    private TableColumn<Empleado,String> cApellidos;
    @FXML
    private TableColumn<Empleado,String> cLocalidad;
    @FXML
    private TableColumn<Empleado,Integer> cSalario;

    @FXML
    private TextField campoLocalidad;
    @FXML
    private Button mostrar;

    @FXML
    private ComboBox<String> comboLocalidades;


    @FXML
    protected void initialize(){
        try{
            con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            // Configurar columnas solo una vez
            cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            cLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
            cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));

            cargarTodos();      // Cargar tabla completa
            cargarLocalidades(); // Cargar el combo

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void cargarTodos() {
        try {
            empleados.getItems().clear();
            String consulta = "SELECT * FROM empleados";
            rs = statement.executeQuery(consulta);

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Localidad"),
                        rs.getInt("Salario")
                );

                empleados.getItems().add(empleado);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void cargarLocalidades() {
        try {
            String sql = "SELECT DISTINCT Localidad FROM datos.empleados";
            ResultSet rs2 = statement.executeQuery(sql);

            while (rs2.next()) {
                comboLocalidades.getItems().add(rs2.getString("Localidad"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void mostrarPorCiudadComboBox() {
        String ciudad = comboLocalidades.getValue();


        try {
            String sql = "SELECT * FROM datos.empleados WHERE Localidad = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ciudad);

            ResultSet resultSet = ps.executeQuery();

            // Lista temporal de resultados
            List<Empleado> lista = new ArrayList<>();

            while (resultSet.next()) {
                Empleado empleado = new Empleado(
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellidos"),
                        resultSet.getString("Localidad"),
                        resultSet.getInt("Salario")
                );

                lista.add(empleado);
            }

            // Abrir nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resultado-view.fxml"));
            Parent root = loader.load();

            ResultadoController controller = loader.getController();
            controller.cargarDatos(lista);

            Stage stage = new Stage();
            stage.setTitle("Resultados de búsqueda");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Mostramos en la tabla la localidad insertada en el textfield
    /*@FXML
    protected void mostrarPorCiudadTextField() {
    String ciudad = campoLocalidad.getText().trim();

    try {
        empleados.getItems().clear();

        String sql = "SELECT * FROM datos.empleados WHERE Localidad = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ciudad);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            Empleado empleado = new Empleado(
                    resultSet.getString("Nombre"),
                    resultSet.getString("Apellidos"),
                    resultSet.getString("Localidad"),
                    resultSet.getInt("Salario")
            );

            empleados.getItems().add(empleado);
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}*/


}