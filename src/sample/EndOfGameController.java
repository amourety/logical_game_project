package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.Scanner;

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
    private Label rightAnswers;

    private FileReader input;

    @FXML
    public void initialize() throws IOException {
        input = new FileReader("lastscores.txt");
        Scanner scan = new Scanner(input);
        String score = "YOUR SCORES: ";
        for(int i = 0; scan.hasNextLine(); i++) {
            score = score + scan.nextLine();
        }


        exitButton.setOnAction(event1 -> {
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
            stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });

        playAgainButton.setOnAction(event2 -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/game1.fxml"));
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
            stage = (Stage) playAgainButton.getScene().getWindow();
            stage.close();

        });
            rightAnswers.setText(score.toString());

    }
}
