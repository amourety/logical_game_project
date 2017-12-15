package sample;

import entities.*;
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

import java.io.*;

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

    private Player p;
    private UnitData unitData = new UnitData();
    private Unit correctUnit;
    private FileWriter out;
    int count = 0;

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
    public void initialize() throws Exception {

        out = new FileWriter("lastscores.txt");
        p = new Player("Vadim");

        rightAnswers.setText(String.valueOf(p.getScore()));
        yesButton.setOnAction(event1 -> {
            count++;
            if (correctUnit.getPure() == 1) {
                p.addScore();
                rightAnswers.setText(String.valueOf(p.getScore()+ "/" + count));
            }
            correctUnit = unitData.random();
            colourChanging(correctUnit.getColorName(),correctUnit.getRgb());
            rightAnswers.setText(String.valueOf(p.getScore()) + "/" + count);
        });

        noButton.setOnAction(event2 -> {
            count++;
            if (correctUnit.getPure() == 0) {
                p.addScore();
                rightAnswers.setText(String.valueOf(p.getScore()) + "/" + count);
            }
            correctUnit = unitData.random();;
            colourChanging(correctUnit.getColorName(),correctUnit.getRgb());
            rightAnswers.setText(String.valueOf(p.getScore()) + "/" + count);
        });
        startButtonForTimer.setOnAction(event3 -> {
            timeStart();
            correctUnit = unitData.random();;
            colourChanging(correctUnit.getColorName(),correctUnit.getRgb());

        });

        nextButton.setOnAction(event4 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/endOfGame.fxml"));
            Parent root1 = null;
            try {
                out.write(String.valueOf(p.getScore()) + "/" + count);
                out.close();
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

        });
    }

    public void colourChanging(String colorName, String rgb){
        colourText.setText(colorName);
        colourText.setFill(Color.valueOf(rgb));
    }


    public void timeStart(){
        if (!timeline.getStatus().equals("paused")) {
            startTimeSec = 30;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    startTimeSec--;
                    boolean timeToChangeBackground = startTimeSec == 0 && startTimeMin == 0;

                    if (timeToChangeBackground) {
                        try {
                            out.write(String.valueOf(p.getScore())+ "/" + count);
                            out.close();
                        }
                        catch(Exception e){
                            System.out.println("PROGRAMA PLOHO RABOTAET");
                        }
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
}


