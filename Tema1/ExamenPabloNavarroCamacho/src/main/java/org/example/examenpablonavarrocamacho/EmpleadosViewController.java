package org.example.examenpablonavarrocamacho;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmpleadosViewController {

    @FXML
    private TableView<Empleado> empleados;
    @FXML
    private TableColumn<Empleado,String> cNombre;
    @FXML
    private TableColumn<Empleado,Double> cSalario;
    @FXML
    private TableColumn<Empleado,Double> cSalarioNeto;
    @FXML
    private TableColumn<Empleado,Double> cDepartamento;

    private Connection con;
    private Statement st;
    private ResultSet rs;;


    @FXML
    public void initialize() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/empresa",
                    "root",
                    "1234"
            );

            st = con.createStatement();

            cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
            cDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
            cSalarioNeto.setCellValueFactory(new PropertyValueFactory<>("salarioNeto"));

            rs = st.executeQuery("SELECT Nombre, Departamento, Salario  FROM empleados");

            while (rs.next()) {
                empleados.getItems().add(
                        new Empleado(
                                rs.getString("Nombre"),
                                rs.getInt("Departamento"),
                                rs.getDouble("Salario")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
