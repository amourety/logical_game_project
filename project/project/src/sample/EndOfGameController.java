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

/**
 * 23.11.2017
 * EndOfGameController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class EndOfGameController {
    @FXML
    private Button exitButton;
    @FXML
    private Button playAgainButton;

    @FXML
    public void initialize(){
        exitButton.setOnAction(event1 ->{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Menu");
            stage.setScene(new Scene(root1));
            stage.show();
            stage = (Stage)exitButton.getScene().getWindow();
            stage.close();
        } );

        playAgainButton.setOnAction(event2 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/game.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("GameAgain");
            stage.setScene(new Scene(root1));
            stage.show();
            stage = (Stage)playAgainButton.getScene().getWindow();
            stage.close();
        });
    }
}
