package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button settingsButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
        startButton.setOnAction(event1 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/howToPlay.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("HowToPlay");
            stage.setScene(new Scene(root1));
            stage.show();
        });
        settingsButton.setOnAction(event2 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/settings.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Settings");
            stage.setScene(new Scene(root1));
            stage.show();
        });
        exitButton.setOnAction(event3 -> {
            Stage stage = (Stage)exitButton.getScene().getWindow();
            stage.close();
        });
    }
}

