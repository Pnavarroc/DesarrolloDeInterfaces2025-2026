package org.example.examenprueba;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {
    private static final String URL = "jdbc:mysql://localhost:3306/centro_formacion";
    private static final String USER = "root";
    private static final String PASSWD = "1234";

    private Connection con;
    private Statement statement;
    private ResultSet rs;

    @FXML
    private TextField nombre;
    @FXML
    private DatePicker fecha_nacimiento;
    @FXML
    private CheckBox hombre;
    @FXML
    private CheckBox mujer;
    @FXML
    private ComboBox<Curso> cursos;

    @FXML
    private TextField nota_media;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu alumno;

    @FXML
    private MenuItem nuevoAlumno;
    @FXML
    private MenuItem guardarAlumno;

    @FXML
    private Menu navegacion;

    @FXML
    private MenuItem primerAlumno;
    @FXML
    private MenuItem siguienteAlumno;
    @FXML
    private MenuItem alumnoAnterior;
    @FXML
    private MenuItem ultimoAlumno;

    @FXML
    private Menu mostrarALumnos;

    @FXML
    private MenuItem siguientePantalla;

    @FXML
    protected void initialize() {

        // CheckBox excluyentes
        hombre.setOnAction(e -> { if (hombre.isSelected()) mujer.setSelected(false); });
        mujer.setOnAction(e -> { if (mujer.isSelected()) hombre.setSelected(false); });

        cargarCursos();
        cargarResultSet();
        cargarPrimerAlumno();
    }

    // ================= CARGAR CURSOS =================
    private void cargarCursos() {
        String sql = "SELECT id, nombre FROM cursos";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                cursos.getItems().add(
                        new Curso(rs.getInt("id"), rs.getString("nombre"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= RESULTSET DESPLAZABLE =================
    private void cargarResultSet() {
        String sql = """
                SELECT nombre, fecha_nacimiento, sexo, nota_media, id_curso
                FROM alumnos
                ORDER BY id
                """;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWD);
            statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= MOSTRAR ALUMNO ACTUAL =================
    private void mostrarAlumnoActual() throws SQLException {

        nombre.setText(rs.getString("nombre"));
        fecha_nacimiento.setValue(rs.getDate("fecha_nacimiento").toLocalDate());
        nota_media.setText(String.valueOf(rs.getDouble("nota_media")));

        int sexo = rs.getInt("sexo");
        hombre.setSelected(sexo == 0);
        mujer.setSelected(sexo == 1);

        int idCursoAlumno = rs.getInt("id_curso");
        for (Curso c : cursos.getItems()) {
            if (c.getId() == idCursoAlumno) {
                cursos.getSelectionModel().select(c);
                break;
            }
        }
    }

    // ================= NAVEGACIÓN =================
    @FXML
    protected void cargarPrimerAlumno() {
        try {
            if (rs.first()) {
                mostrarAlumnoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ultimoAlumnoAction() {
        try {
            if (rs.last()) {
                mostrarAlumnoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void siguienteAlumnoAction() {
        try {
            if (!rs.isLast() && rs.next()) {
                mostrarAlumnoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void alumnoAnteriorAction() {
        try {
            if (!rs.isFirst() && rs.previous()) {
                mostrarAlumnoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= NUEVO ALUMNO =================
    @FXML
    protected void nuevoAlumnoAction() {
        nombre.clear();
        fecha_nacimiento.setValue(null);
        nota_media.clear();
        hombre.setSelected(false);
        mujer.setSelected(false);
        cursos.getSelectionModel().clearSelection();
    }

    // ================= GUARDAR ALUMNO =================
    @FXML
    protected void guardarAlumnoAction() {

        if (nombre.getText().isEmpty()
                || fecha_nacimiento.getValue() == null
                || cursos.getSelectionModel().getSelectedItem() == null
                || (!hombre.isSelected() && !mujer.isSelected())) {

            new Alert(Alert.AlertType.ERROR,
                    "Rellena todos los campos obligatorios").showAndWait();
            return;
        }

        int sexo = hombre.isSelected() ? 0 : 1;
        Curso curso = cursos.getSelectionModel().getSelectedItem();

        String sql = """
                INSERT INTO alumnos (nombre, fecha_nacimiento, sexo, nota_media, id_curso)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre.getText());
            ps.setDate(2, Date.valueOf(fecha_nacimiento.getValue()));
            ps.setInt(3, sexo);
            ps.setDouble(4,
                    nota_media.getText().isEmpty() ? 0 : Double.parseDouble(nota_media.getText()));
            ps.setInt(5, curso.getId());

            ps.executeUpdate();

            // recargar navegación
            cargarResultSet();
            rs.last();
            mostrarAlumnoActual();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirVentanaTabla() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tabla-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Listado de Alumnos");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}