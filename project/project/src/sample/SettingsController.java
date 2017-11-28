package sample;

import entities.media.DataReader;
import entities.media.DataReaderException;
import entities.media.DataReaderFactory;
import entities.media.MediaPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * 21.11.2017
 * SettingsController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class SettingsController {
    @FXML
    private Button musicOn;
    @FXML
    private Button musicOff;
    @FXML
    private Button backToMenu;

    @FXML
    public void initialize() {
        MediaPlayer mediaPlayer = MediaPlayer.getInstance();
        musicOn.setOnAction(event1 -> {
            try {
                File f = new File("C:\\Users\\Guzel\\Desktop\\logical_game_project\\project\\project\\src\\data\\music.wav");
                URI path = f.toURI();
                DataReader dataReader = DataReaderFactory.getProduct();
                mediaPlayer.setTrack(dataReader.read(path));

                mediaPlayer.play();
            }
            catch (DataReaderException ex){
                getErrorInfo(ex, "Ошибка в DataReader");
            }
        });
        musicOff.setOnAction(event2 -> {
            mediaPlayer.stop();
        });
        backToMenu.setOnAction(event3 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Menu");
            stage.setScene(new Scene(root1));
            stage.show();
            stage = (Stage)backToMenu.getScene().getWindow();
            stage.close();
        });
    }
    public static void getErrorInfo(Exception ex, String msg) {
        System.out.print(msg);
        System.err.println(ex.getMessage());
        System.exit(1);
    }
}
