package org.example.examenprueba;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class TablaController {

    private static final String URL = "jdbc:mysql://localhost:3306/centro_formacion";
    private static final String USER = "root";
    private static final String PASSWD = "1234";

    @FXML
    private TableView<Alumno> alumnos;

    @FXML
    private TableColumn<Alumno, String> nombre;
    @FXML
    private TableColumn<Alumno, String> nombreCurso;
    @FXML
    private TableColumn<Alumno, Double> notaMedia;
    @FXML
    private TableColumn<Alumno, Double> notaFinal;

    @FXML
    protected void initialize() {

        // Enlazar columnas con el modelo
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreCurso.setCellValueFactory(new PropertyValueFactory<>("nombreCurso"));
        notaMedia.setCellValueFactory(new PropertyValueFactory<>("nota_media"));
        notaFinal.setCellValueFactory(new PropertyValueFactory<>("notaFinal"));

        String sql = """
                SELECT a.nombre, c.nombre AS nombreCurso, a.nota_media
                FROM alumnos a
                JOIN cursos c ON a.id_curso = c.id
                """;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                double notaMediaBD = rs.getDouble("nota_media");
                double notaFinalCalc = notaMediaBD * 1.1;

                Alumno alumno = new Alumno(
                        rs.getString("nombre"),
                        rs.getString("nombreCurso"),
                        notaMediaBD,
                        notaFinalCalc
                );

                alumnos.getItems().add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
