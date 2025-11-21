package org.example.examenpablonavarrocamacho;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloController {

    private static String URL = "jdbc:mysql://localhost:3306/empresa";
    private static String USER = "root";
    private static String PASS = "1234";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    @FXML
    private DatePicker fechaNacimiento;

    @FXML
    private RadioButton hombre;
    @FXML
    private RadioButton mujer;

    @FXML
    private ComboBox<String> listadoDepartamentos;

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoSalario;




    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem gestion;
    @FXML
    private MenuItem Desplazamiento;
    @FXML
    private MenuItem Listados;
    @FXML
    private MenuItem nuevoEmpleado;

    @FXML
    private MenuItem guardarEmpleado;

    @FXML
    private MenuItem primero;
    @FXML
    private MenuItem anterior;
    @FXML
    private MenuItem siguiente;
    @FXML
    private MenuItem ultimo;
    @FXML
    private MenuItem pasarAsiguienteVentana;


    @FXML
    protected void initialize(){
        try{
            con = DriverManager.getConnection(URL, USER, PASS);
            st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );


            rs = st.executeQuery("SELECT * FROM empresa.empleados");

            if (rs.next()) {
                mostrarRegistroActual();
            }

            cargarDepartamento();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void mostrarRegistroActual() throws SQLException {
        campoId.setText(rs.getString("Id"));
        campoNombre.setText(rs.getString("Nombre"));
        listadoDepartamentos.setValue(rs.getString("departamento"));
        campoSalario.setText(rs.getString("Salario"));
    }

    @FXML
    protected void ponerCamposVacios(){
        campoId.clear();
        campoNombre.clear();
        listadoDepartamentos.setValue(null);
        campoSalario.clear();
    }


    private void cargarDepartamento() {
        try {
            String sql = "SELECT DISTINCT Departamento FROM empresa.departamentos";
            ResultSet rs2 = st.executeQuery(sql);

            while (rs2.next()) {
                listadoDepartamentos.getItems().add(rs2.getString("Departamento"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    protected void ponerPrimeroRegistro(){
        try{
            if (rs.first()){
                mostrarRegistroActual();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void ponerUltimoRegistro(){
        try{
            if (rs.last()){
                mostrarRegistroActual();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlSiguiente(){
        try{
            if (rs.next()){
               mostrarRegistroActual();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void pasarAlanterior(){
        try{
            if (rs.previous()){
                mostrarRegistroActual();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void guardarEnBaseDeDatos(){

        try {
            String consulta= "INSERT INTO empleados(Nombre, Departamento, Salario) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(consulta);
            preparedStatement.setString(1,campoNombre.getText());
            //preparedStatement.setDate(2, (Date) fechaNacimiento.getDayCellFactory());
            preparedStatement.setString(2,listadoDepartamentos.getValue());
            preparedStatement.setString(3, String.valueOf(Double.parseDouble(campoSalario.getText())));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void abrirVentanaEmpleados() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("empleados-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Listado de Empleados");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}