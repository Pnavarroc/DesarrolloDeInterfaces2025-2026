package org.example.examenrecuperacion1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class TablaController {
    private static final String URL = "jdbc:mysql://localhost:3306/productos";
    private static final String USER = "root";
    private static final String PASSWD = "1234";


    @FXML
    private TableView<Producto> productos;
    @FXML
    private TableColumn<Producto, String> nombreProducto;
    @FXML
    private TableColumn<Producto, Double> precioProducto;
    @FXML
    private TableColumn<Producto, Double> precioIVAProducto;

    @FXML
    private TableColumn<Producto, String> categoriaProducto;
    @FXML
    private TableColumn<Producto, String> marcaProducto;
    @FXML
    private TableColumn<Producto, Integer> estadoProducto;

    @FXML

    protected void initialize(){
// Enlazar columnas con el modelo
        nombreProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        precioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
        precioIVAProducto.setCellValueFactory(new PropertyValueFactory<>("precioIVA"));
        categoriaProducto.setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        marcaProducto.setCellValueFactory(new PropertyValueFactory<>("nombreMarca"));
        estadoProducto.setCellValueFactory(new PropertyValueFactory<>("estado"));

        String sql = """
                    SELECT p.producto , p.precio , c.categoria AS nombreCategoria,
                     m.marca AS nombreMarca, p.estado AS estado FROM productos p
                    JOIN marcas m ON p.marca=m.id JOIN categorias c ON p.categoria=c.id
                """;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                double precioDB = rs.getDouble("precio");
                double precioIVA = precioDB * 1.21;

                Producto producto = new Producto(
                        rs.getString("producto"),
                        precioDB,
                        precioIVA,
                        rs.getString("nombreCategoria"),
                        rs.getString("nombreMarca"),
                        rs.getInt("estado")

                );

                productos.getItems().add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//SELECT p.producto, p.precio, c.categoria, m.marca, p.estado FROM productos p
// JOIN marcas m ON p.marca=m.id JOIN categorias c ON p.categoria=c.id;
