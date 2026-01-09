package org.example.ejerciciotablabasico;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class HelloController {

    private static String URL = "jdbc:mysql://localhost:3306/empresa2";
    private static String USUARIO= "root";
    private static String PASSWD= "1234";

    @FXML
    private TableView<Empleado> empleados;
    @FXML
    private TableColumn<Empleado,Long> idColumn;
    @FXML
    private TableColumn<Empleado,String> nombreColumn;
    @FXML
    private TableColumn<Empleado,Double> salarioColumn;
    @FXML
    private TableColumn<Empleado,Long> id_departamentoColumn;
    @FXML
    private TableColumn<Empleado,String> nombreDepartamento;

    @FXML
    private TextField campoSalario;
    @FXML
    private Button filtrarSalario;


    @FXML
    private Button mostrarEmpleados;


    @FXML
    protected void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        salarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));
        id_departamentoColumn.setCellValueFactory(new PropertyValueFactory<>("id_departamento"));
        nombreDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

    }

    @FXML
    protected void mostrarEmpleadosAction(){

        empleados.getItems().clear();
        String consulta= """
                SELECT e.id, e.nombre, e.salario, e.id_departamento, d.nombre as departamento from empleado e JOIN
                 departamento d ON e.id_departamento=d.id
                """;
        try (Connection con = DriverManager.getConnection(URL,USUARIO,PASSWD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

        ){


            while (rs.next()){
                Empleado empleado = new Empleado(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getDouble("salario"),
                        rs.getLong("id_departamento"),
                        rs.getString("departamento")
                );
                empleados.getItems().add(empleado);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void filtrarPorSalario(){



        if (!campoSalario.getText().isEmpty()){
            double sal = Double.parseDouble(campoSalario.getText());
            empleados.getItems().clear();
            String consulta= """
                SELECT e.id, e.nombre, e.salario, e.id_departamento, d.nombre as departamento from empleado e JOIN
                 departamento d ON e.id_departamento=d.id WHERE e.salario>?
                 """;
            try (Connection con = DriverManager.getConnection(URL,USUARIO,PASSWD);
                 PreparedStatement ps =con.prepareStatement(consulta);

            ){
                ps.setDouble(1,sal);

                try{
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                        Empleado empleado = new Empleado(
                                rs.getLong("id"),
                                rs.getString("nombre"),
                                rs.getDouble("salario"),
                                rs.getLong("id_departamento"),
                                rs.getString("departamento")
                        );
                        empleados.getItems().add(empleado);

                    }
                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            empleados.getItems().clear();
        }




    }
}

