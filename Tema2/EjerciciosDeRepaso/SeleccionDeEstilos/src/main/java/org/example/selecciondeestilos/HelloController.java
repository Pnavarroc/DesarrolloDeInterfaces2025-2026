package org.example.selecciondeestilos;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private ComboBox comboBox;

    @FXML
    private CheckBox checkBox;

    @FXML
    private RadioButton radioButton;

    @FXML
    private Slider slider;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private AnchorPane panel;

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    protected void initialize(){
        panel.getStylesheets().clear();
        comboBox.getItems().addAll("estilos1", "estilos2", "estilos3");


        // Configurar el slider para actualizar los indicadores de progreso
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.doubleValue() / 100.0;
            progressBar.setProgress(progress);
            progressIndicator.setProgress(progress);
        });

    }

    @FXML
    protected void cambiardeEstilos(){
        if (comboBox.getValue().equals("estilos1")){
            panel.getStylesheets().add(getClass().getResource("estilos1.css").toExternalForm());
        } else if (comboBox.getValue().equals("estilos2")) {
            panel.getStylesheets().add(getClass().getResource("estilos2.css").toExternalForm());

        }else if (comboBox.getValue().equals("estilos3")) {
            panel.getStylesheets().add(getClass().getResource("estilos3.css").toExternalForm());

        }
    }




}