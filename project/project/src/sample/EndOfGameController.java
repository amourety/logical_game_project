package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.models.User;

import java.io.IOException;
import java.util.Scanner;

/**
 * 23.11.2017
 * EndOfGameController
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class EndOfGameController {

    private Game1Controller game1Controller = new Game1Controller();
    private ObservableList<User> usersData = FXCollections.observableArrayList();
    @FXML
    private Button exitButton;
    @FXML
    private Button playAgainButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, Integer> resultsColumn;
    @FXML
    private Button addResultButton;

    private String name;

    @FXML
    public void initialize() {
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
            stage = (Stage) playAgainButton.getScene().getWindow();
            stage.close();
        });
        nameTextField.setOnAction(event3 -> {
            name = nameTextField.getText();
        });

        addResultButton.setOnAction(event4 -> {
            initData();
            nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            resultsColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("results"));
            tableView.setItems(usersData);
        });
    }

    private void initData() {
        usersData.add(new User(name, game1Controller.getCounter()));
    }
}
