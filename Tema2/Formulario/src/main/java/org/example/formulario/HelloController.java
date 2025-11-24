package org.example.formulario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private Label titulo;

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellidos;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoPassword;
    @FXML
    private TextField campoConfirmPassword;

    @FXML
    private CheckBox acepto;
    @FXML
    private CheckBox noAcepto;
    @FXML
    private Button registerNow;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    protected void initialize(){
        anchorPane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }
}