package controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dataStore;

import src.helper.helper_data;


public class ControllerDetail extends dataStore implements Initializable {

    @FXML
    private JFXButton homeButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private ListView<String> connectListView;

    @FXML
    private JFXTextArea infoText;

    private String dataName;
    private String currentActivity;

    @FXML
    private void backHome(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) homeButton.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/view/stylesheet.css").toExternalForm());
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @FXML
    private void showConnect(MouseEvent event) {
        if (event.getClickCount() == 2) {
            String selectedItem = connectListView.getSelectionModel().getSelectedItem();
           helper_data.updateUser(currentActivity, selectedItem, nameLabel, connectListView, infoText, idLabel, character, ditichVN, festivalsArr, dynastiesArr, eventArr);
        }
    }
    // helper function

    public void setData(String data, String current) {
        this.dataName = new String(data);
        this.currentActivity = current;
        updateUser();
        // System.out.print(dataName);
    }

    public void updateUser() {
        if (dataName != null) {
            helper_data.updateUser(currentActivity, dataName, nameLabel, connectListView, infoText, idLabel, character, ditichVN, festivalsArr, dynastiesArr, eventArr);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    // Other methods and code for your controller
}
