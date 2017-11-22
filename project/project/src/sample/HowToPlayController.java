package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

/**
 * 21.11.2017
 * HowToPlayController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class HowToPlayController {
    @FXML
    private Button startButton;

   @FXML
   public void initialize(){
       startButton.setOnAction(event1 -> {
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
           stage.setTitle("Game");
           stage.setScene(new Scene(root1));
           stage.show();
           stage = (Stage)startButton.getScene().getWindow();
           stage.close();
       });
   }
}
