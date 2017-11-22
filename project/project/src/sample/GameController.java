package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 * 21.11.2017
 * GameController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class GameController {
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    @FXML
    public void initialize(){
        //пишем что будет, если нажать yes/no
        yesButton.setOnAction(event1 ->{

        } );
        noButton.setOnAction(event2 ->{

        } );
    }

}
