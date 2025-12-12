package org.example.examenpablonavarrocss;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloController {
    @FXML
    private AnchorPane panel;

    @FXML
    private MenuBar menu;
    @FXML
    private MenuItem estilos1;
    @FXML
    private MenuItem estilos2;
    @FXML
    private MenuItem sinEstilo;
    @FXML
    private MenuItem ayuda;

    @FXML
    private ToggleButton togleF;
    @FXML
    private ToggleButton togleAM;
    @FXML
    private ToggleButton toglePV;
    @FXML
    private ToggleButton togleN;

    @FXML
    private RadioButton radioF;
    @FXML
    private RadioButton radioAM;
    @FXML
    private RadioButton radioPV;
    @FXML
    private RadioButton radioN;

    @FXML
    private ProgressBar progresAtencion;

    @FXML
    private ProgressIndicator progresIndicatorHabla;

    @FXML
    private Label independencia;

    @FXML
    protected void initialize(){
        ToggleGroup toggleGroupRadio = new ToggleGroup();
        radioF.setToggleGroup(toggleGroupRadio);
        radioAM.setToggleGroup(toggleGroupRadio);
        radioPV.setToggleGroup(toggleGroupRadio);
        radioN.setToggleGroup(toggleGroupRadio);

        ToggleGroup toggleGroup = new ToggleGroup();
        togleF.setToggleGroup(toggleGroup);
        togleAM.setToggleGroup(toggleGroup);
        toglePV.setToggleGroup(toggleGroup);
        togleN.setToggleGroup(toggleGroup);

    }

    @FXML
    protected void cambiarProgressIndicator(){
        if (radioF.isSelected()){
            progresIndicatorHabla.setProgress(0);
            progresIndicatorHabla.setProgress(1);
        } else if (radioAM.isSelected()) {
            progresIndicatorHabla.setProgress(0);
            progresIndicatorHabla.setProgress(0.75);
        }else if (radioPV.isSelected()) {
            progresIndicatorHabla.setProgress(0);
            progresIndicatorHabla.setProgress(0.50);
        }else if (radioN.isSelected()) {
            progresIndicatorHabla.setProgress(0);
            progresIndicatorHabla.setProgress(0.25);
        }
    }

    @FXML
    protected void cambiarProgressBar(){
        if (togleF.isSelected()){
            progresAtencion.setProgress(0);
            progresAtencion.setProgress(1);
        } else if (togleAM.isSelected()) {
            progresAtencion.setProgress(0);
            progresAtencion.setProgress(0.75);
        }else if (toglePV.isSelected()) {
            progresAtencion.setProgress(0);
            progresAtencion.setProgress(0.50);
        }else if (togleN.isSelected()) {
            progresAtencion.setProgress(0);
            progresAtencion.setProgress(0.25);
        }
    }

    @FXML
    protected void ayudaCHM(){
        try {
            Desktop.getDesktop().browse(new URI("Ayuda.chm"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void cambiarEstilos1(){
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());
    }
    @FXML
    protected void cambiarEstilos2(){
        panel.getStylesheets().clear();
        panel.getStylesheets().add(getClass().getResource("style2.css").toExternalForm());
    }
    @FXML
    protected void resetear(){
        panel.getStylesheets().clear();

    }

}