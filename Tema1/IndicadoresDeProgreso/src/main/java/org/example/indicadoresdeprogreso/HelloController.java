package org.example.indicadoresdeprogreso;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private ProgressBar progressBar ;
    @FXML
    private Button menosProgresbar;
    @FXML
    private Button masProgressBar;
    @FXML
    private TextField textFieldProgressBar;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Button menosProgresIndicator;
    @FXML
    private Button masProgressIndicator;
    @FXML
    private TextField textFieldProgressIndicator;

    @FXML
    private Slider slider;
    @FXML
    private Button menoSlider;
    @FXML
    private Button masSlider;
    @FXML
    private TextField textFieldSlider;

    @FXML
    private Spinner<Integer> spinner;


    @FXML
    protected void restarProgressBar(){
        double valor = progressBar.getProgress()-0.1;
        if (valor<0){
            valor=0;
        }progressBar.setProgress(valor);

        textFieldProgressBar.setText(String.valueOf(valor));
    }
    @FXML
    protected void sumarProgressBar(){
        double valor = progressBar.getProgress()+0.1;
        if (valor>1){
            valor=1;
        }
        progressBar.setProgress(valor);

        textFieldProgressBar.setText(String.valueOf(valor));

    }


    @FXML
    protected void sumarProgressIndicator(){
        double valor = progressIndicator.getProgress()+0.1;
        if (valor>1){
            valor=1;
        }
        progressIndicator.setProgress(valor);

        textFieldProgressIndicator.setText(String.valueOf(valor));

    }
    @FXML
    protected void restarProgressIndicator(){
        double valor = progressIndicator.getProgress()-0.1;
        if (valor<0){
            valor=0;
        }progressIndicator.setProgress(valor);

        textFieldProgressIndicator.setText(String.valueOf(valor));
    }


    @FXML
    protected void restarSlider(){
        slider.decrement();
        textFieldSlider.setText(String.valueOf(slider.getValue()));

    }
    @FXML
    protected void sumarSlider(){
        slider.increment();
        textFieldSlider.setText(String.valueOf(slider.getValue()));

    }

    @FXML
    protected void initialize(){
        spinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,70,5)
        );
    }



}