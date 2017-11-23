package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;


/**
 * 21.11.2017
 * GameController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class GameController {

    private Timeline timeline = new Timeline();
    private int startTimeSec, startTimeMin;
    private int counter = 0;
    private final int MAX_COUNT_OF_RIGHT_NUMBERS = 5;

    private String a = "BLACK";
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    @FXML
    private Label timerText;
    @FXML
    private Text colourText;
    @FXML
    private Button startButtonForTimer;
    @FXML
    private Label rightAnswers;

    public void timeStart(){
        if(!timeline.getStatus().equals("paused")){
            startTimeSec = 30;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    startTimeSec--;
                    boolean timeToChangeBackground = startTimeSec == 0 && startTimeMin==0;

                    if (timeToChangeBackground) {
                        timeline.stop();
                        startTimeSec = 0;
                        startTimeMin=0;
                        timerText.setTextFill(Color.RED);
                    }
                    timerText.setText(String.format("%d:%02d", startTimeMin, startTimeSec));
                }
            }));
            timeline.playFromStart();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION ,  "You have not entered a time!");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        //пишем что будет, если нажать yes/no
        //пример с текстом и цветом
        rightAnswers.setText(String.valueOf(counter));
            yesButton.setOnAction(event1 -> {
                colourText.setText(a);
                colourText.setFill(Color.RED);
                //нужно наложить условие правильно или нет
                    counter++;
                    rightAnswers.setText(String.valueOf(counter));
                    endGame();
            });

        noButton.setOnAction(event2 -> {
            colourText.setText("BLUE");
            colourText.setFill(Color.BISQUE);
            //нужно наложить условие правильно или нет
            counter++;
            rightAnswers.setText(String.valueOf(counter));
            endGame();

        });
        startButtonForTimer.setOnAction(event3 ->{
            timeStart();
        } );
    }

    public void endGame(){
        if(counter == MAX_COUNT_OF_RIGHT_NUMBERS ){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/endOfGame.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("EndOfGame");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }
}