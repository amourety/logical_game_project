package sample;

import entities.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
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
 * 25.11.2017
 * Game1Controller
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class Game1Controller {
    private Timeline timeline = new Timeline();
    private int startTimeSec, startTimeMin;
    private Player p = new Player("Vadim");
    private Randomizer r = new Randomizer();
    private UnitData unitData = new UnitData();
    private Unit correctUnit;



    public int getCounter() {
        return counter;
    }

    private int counter = 0;
    private String a = "BLACK";

    @FXML
    private Label rightAnswers;
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
    private Button nextButton;
    @FXML
    public void initialize() {
        rightAnswers.setText(String.valueOf(p.getScore()));
        yesButton.setOnAction(event1 -> {
            if(correctUnit.getPure() == 1) {
                p.addScore();
            }
            rightAnswers.setText(String.valueOf(p.getScore()));
            correctUnit = r.random(unitData.getUnits());
            colourText.setText(correctUnit.getColorName());
            colourText.setFill(Color.valueOf(correctUnit.getRgb()));
        });

        noButton.setOnAction(event2 -> {
            if(correctUnit.getPure() == 0) {
                p.addScore();
            }
            rightAnswers.setText(String.valueOf(p.getScore()));
            correctUnit = r.random(unitData.getUnits());
            colourText.setText(correctUnit.getColorName());
            colourText.setFill(Color.valueOf(correctUnit.getRgb()));
        });
        startButtonForTimer.setOnAction(event3 -> {
            timeStart();
            correctUnit = r.random(unitData.getUnits());
            colourText.setText(correctUnit.getColorName());
            colourText.setFill(Color.valueOf(correctUnit.getRgb()));
        });

        nextButton.setOnAction(event4 ->{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/endOfGame.fxml"));
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
            stage.setTitle("End");
            stage.setScene(new Scene(root1));
            stage.show();
            stage = (Stage)nextButton.getScene().getWindow();
            stage.close();

        } );
    }


    public void timeStart() {
        if (!timeline.getStatus().equals("paused")) {
            startTimeSec = 30;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    startTimeSec--;
                    boolean timeToChangeBackground = startTimeSec == 0 && startTimeMin == 0;

                    if (timeToChangeBackground) {
                        timeline.stop();
                        startTimeSec = 0;
                        startTimeMin = 0;
                        timerText.setTextFill(Color.RED);
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
                        stage.setTitle("Game");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    timerText.setText(String.format("%d:%02d", startTimeMin, startTimeSec));
                }
            }));
            timeline.playFromStart();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have not entered a time!");
            alert.showAndWait();
        }
    }
    public int getAmswers(){
        return p.getScore();
    }
}
