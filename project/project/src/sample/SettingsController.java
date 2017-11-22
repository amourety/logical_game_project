package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * 21.11.2017
 * SettingsController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class SettingsController {
    private Stage window;
    @FXML
    private CheckBox musicOn;
    @FXML
    private CheckBox musicOff;
    @FXML
    private Button backToMenu;

    @FXML
    public void initialize() {
        //тут действия с музыкой, вместо setText пишем код
        musicOn.setOnAction(event1 -> {
            musicOn.setText("");
        });
        musicOff.setOnAction(event2 -> {
            musicOff.setText("");
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
}
