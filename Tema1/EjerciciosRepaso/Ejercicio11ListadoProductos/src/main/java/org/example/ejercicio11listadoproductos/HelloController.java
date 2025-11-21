package org.example.ejercicio11listadoproductos;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoUnidades;
    @FXML
    private TextField campoPrecio;

    @FXML
    private Button nuevoProd;
    @FXML
    private Button agregarAlaLista;

    @FXML
    private TableView<Producto> productos;

    @FXML
    private TableColumn<Producto,String> cNombre;
    @FXML
    private TableColumn<Producto,Integer> cUnidades;
    @FXML
    private TableColumn<Producto,Double> cPrecio;
    @FXML
    private TableColumn<Producto,Double> cSubtotal;
    @FXML
    private TextField campoTotal;
    @FXML
    protected void initialize(){
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cUnidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        cPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal")); // metodo getSubtotal()

    }
    @FXML
    private void agregarProducto() {

        String nombre = campoNombre.getText();
        Integer unidades = Integer.parseInt(campoUnidades.getText());
        Double precio = Double.parseDouble(campoPrecio.getText());

        Producto producto = new Producto(nombre, unidades, precio);

        productos.getItems().add(producto);

        calcularTotal();
    }
    @FXML
    private void limpiarCampos() {
        campoNombre.clear();
        campoUnidades.clear();
        campoPrecio.clear();
    }
    private void calcularTotal() {
        double total = 0;

        for (Producto p : productos.getItems()) {
            total += p.getSubtotal();
        }

        campoTotal.setText(String.format("%.2f", total));
    }


}