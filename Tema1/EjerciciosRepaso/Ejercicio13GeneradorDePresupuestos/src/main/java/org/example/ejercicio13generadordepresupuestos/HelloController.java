package org.example.ejercicio13generadordepresupuestos;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellidos;

    @FXML
    private DatePicker campoFecha;

    @FXML
    private Spinner<Integer> campoDuracion;

    @FXML
    private TextField campoInvitados;

    @FXML
    private ComboBox comboMenu;

    @FXML
    private CheckBox extraDisco;
    @FXML
    private CheckBox extraAnimacion;
    @FXML
    private CheckBox extraTransporte;

    @FXML
    private TextField campoTotal;

    @FXML
    protected void initialize() {

        campoDuracion.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1)
        );

        comboMenu.getItems().addAll(
                "Picoteo (10 € / persona)",
                "Menú 1 (15 € / persona)",
                "Menú 2 (20 € / persona)"
        );
    }

    @FXML
    private void calcular() {

        int invitados = Integer.parseInt(campoInvitados.getText());
        int duracion = campoDuracion.getValue();

        // Precio menú según lo seleccionado en el ComboBox
        double precioMenu = 0;

        String seleccion = comboMenu.getValue().toString();

        if (seleccion.contains("Picoteo")) precioMenu = 10;
        if (seleccion.contains("Menú 1")) precioMenu = 15;
        if (seleccion.contains("Menú 2")) precioMenu = 20;

        // Coste menú total
        double totalMenu = invitados * precioMenu;

        // Coste duración
        double totalDuracion = invitados * duracion * 10;

        // Extras
        double extras = 0;
        if (extraDisco.isSelected()) extras += 200;
        if (extraAnimacion.isSelected()) extras += 100;
        if (extraTransporte.isSelected()) extras += invitados * 5;

        double total = totalMenu + totalDuracion + extras;

        campoTotal.setText(String.format("%.2f €", total));
    }

}