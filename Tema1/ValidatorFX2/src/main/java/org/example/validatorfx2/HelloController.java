package org.example.validatorfx2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label etiqueta;

    @FXML
    private Button hola;
    @FXML
    private Button adios;

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu rock;
    @FXML
    private Menu pop;
    @FXML
    private Menu tecno;

    @FXML
    private MenuItem menuCancion1;
    @FXML
    private MenuItem menuCancion2;
    @FXML
    private MenuItem menuCancion3;

    /*@FXML
    private ComboBox canciones;
*/
    @FXML
    private Button iniciar;

    @FXML
    private Button pausar;

    @FXML
    private Button acabar;




    @FXML
    protected void initialize(){

        hola.setOnAction(e-> etiqueta.setText("Hola"));
        adios.setOnAction(e-> etiqueta.setText("Adios"));

       // Media media = new Media(cancion1);

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("./musica/music1.mp3").toURI().toString()));

        menuCancion1.setOnAction(e->mediaPlayer = new MediaPlayer(new Media(new File("./musica/music1.mp3").toURI().toString()));
        menuCancion2.setOnAction(e->mediaPlayer = new MediaPlayer(new Media(new File("./musica/music2.mp3").toURI().toString()));
        menuCancion3.setOnAction(e->mediaPlayer = new MediaPlayer(new Media(new File("./musica/music3.mp3").toURI().toString()));


        iniciar.setOnAction(e->mediaPlayer.play());
        pausar.setOnAction(e->mediaPlayer.pause());
        acabar.setOnAction(e->mediaPlayer.stop());




        /**
         String audioFile;

        canciones.getItems().addAll("Canción1", "Canción2", "Canción3");

        if (canciones.getItems().equals("Canción1")){
            audioFile = new File("./musica/music1.mp3").toURI().toString();

        } else if (canciones.getItems().equals("Canción2")) {
            audioFile = new File("./musica/music2.mp3").toURI().toString();

        }else if (canciones.getItems().equals("Canción3")) {
            audioFile = new File("./musica/music3.mp3").toURI().toString();
        }

        String audioFile = new File("./musica/music3.mp3").toURI().toString();
        Media media = new Media(audioFile);
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        iniciar.setOnAction(e->mediaPlayer.play());
        pausar.setOnAction(e->mediaPlayer.pause());
        acabar.setOnAction(e->mediaPlayer.stop());
         */
    }


}