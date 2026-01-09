package org.example.examenrecuperacion1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {
    private static final String URL = "jdbc:mysql://localhost:3306/productos";
    private static final String USER = "root";
    private static final String PASSWD = "1234";

    private Connection con;
    private Statement statement;
    private ResultSet rs;

    @FXML
    private TextField campoNombre;
    @FXML
    private ComboBox<Categoria> categorias;
    @FXML
    private CheckBox cbBluetooth;
    @FXML
    private CheckBox cbNfc;
    @FXML
    private CheckBox cb5g;
    @FXML
    private CheckBox cbWifi;

    @FXML
    private RadioButton rbNuevo;
    @FXML
    private RadioButton rbReacondicionado;

    @FXML
    private TextField campoPrecio;
    @FXML
    private ComboBox<Marca> marcas;

    @FXML
    private Button nuevoProd;
    @FXML
    private Button guardarProd;
    @FXML
    private Button primerProd;
    @FXML
    private Button siguienteProd;
    @FXML
    private Button anteriorProd;
    @FXML
    private Button ultimoProd;
    @FXML
    private Button nuevaVentana;

    @FXML
    protected void initialize(){

        cargarCategorias();
        cargarMarcas();
        cargarResultSet();

    }

    private void cargarCategorias(){
        String sql= """
                    SELECT id, categoria FROM categorias
                """;

        try(Connection con = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                categorias.getItems().add(new Categoria(rs.getInt("id"),rs.getString("categoria")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarMarcas(){
        String sql= """
                    SELECT id, marca FROM marcas
                """;

        try(Connection con = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                marcas.getItems().add(new Marca(rs.getInt("id"),rs.getString("marca")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarResultSet(){
        String sql= """
                    SELECT producto, precio, categoria, marca, wifi, bluetooth, nfc, 5g, estado FROM productos ORDER BY id
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

    private void mostrarProductoActual(){

        try {
            campoNombre.setText(rs.getString("producto"));
            campoPrecio.setText(String.valueOf(rs.getDouble("precio")));

            int idCategoria = rs.getInt("categoria");
            for (Categoria c : categorias.getItems()) {
                if (c.getId() == idCategoria) {
                    categorias.getSelectionModel().select(c);
                    break;
                }
            }

            int idMarca = rs.getInt("marca");
            for (Marca m : marcas.getItems()) {
                if (m.getId() == idMarca) {
                    marcas.getSelectionModel().select(m);
                    break;
                }
            }

            int wifi = rs.getInt("wifi");
            cbWifi.setSelected(wifi == 1);

            int bluetooth = rs.getInt("bluetooth");
            cbBluetooth.setSelected(bluetooth == 1);

            int nfc = rs.getInt("nfc");
            cbNfc.setSelected(nfc == 1);

            int g5 = rs.getInt("5g");
            cb5g.setSelected(g5 == 1);

            ToggleGroup toggleGroupRadio = new ToggleGroup();
            rbNuevo.setToggleGroup(toggleGroupRadio);
            rbReacondicionado.setToggleGroup(toggleGroupRadio);

            int estado = rs.getInt("estado");
            rbNuevo.setSelected(estado==0);
            rbReacondicionado.setSelected(estado==1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    protected void cargarPrimerProducto() {
        try {
            if (rs.first()) {
                mostrarProductoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void cargarUltimoProducto() {
        try {
            if (rs.last()) {
                mostrarProductoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void siguienteProducto() {
        try {
            if (!rs.isLast() && rs.next()) {
                mostrarProductoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void productoAnterior() {
        try {
            if (!rs.isFirst() && rs.previous()) {
                mostrarProductoActual();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void nuevoRegistro(){
        campoNombre.clear();
        campoPrecio.clear();
        categorias.getSelectionModel().clearSelection();
        marcas.getSelectionModel().clearSelection();
        cbBluetooth.setSelected(false);
        cbNfc.setSelected(false);
        cb5g.setSelected(false);
        cbWifi.setSelected(false);
        rbNuevo.setSelected(false);
        rbReacondicionado.setSelected(false);
    }

    @FXML
    protected void guardarProducto(){

        String sql= """
                    INSERT INTO productos (producto, precio, categoria, marca, wifi, bluetooth, nfc, 5g, estado)
                    VALUES(?,?,?,?,?,?,?,?,?)
                """;

        int estado = rbNuevo.isSelected() ? 0 : 1;
        Categoria categoria = categorias.getSelectionModel().getSelectedItem();
        Marca marca = marcas.getSelectionModel().getSelectedItem();

        int wifi = cbWifi.isSelected() ? 1 : 0 ;
        int bluetooth = cbBluetooth.isSelected() ? 1 : 0;
        int nfc = cbNfc.isSelected() ? 1 : 0;
        int g5 = cb5g.isSelected() ? 1 : 0;


        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, campoNombre.getText());
            ps.setDouble(2,Double.parseDouble(campoPrecio.getText()));
            ps.setInt(3, categoria.getId());
            ps.setInt(4, marca.getId());
            ps.setInt(5,wifi);
            ps.setInt(6,bluetooth);
            ps.setInt(7,nfc);
            ps.setInt(8,g5);
            ps.setInt(9,estado);

            ps.executeUpdate();

            // recargar navegación
            cargarResultSet();
            rs.last();
            mostrarProductoActual();

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
            stage.setTitle("Listado de Productos");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}