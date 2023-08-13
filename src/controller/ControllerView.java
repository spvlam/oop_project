package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dataStore;
import src.characterNKS.characterNKS;
import src.dynasty.dynasty;
import src.eventnks.eventnks;
import src.festival.festival;
import src.vietnam.diTichTrenVietnam;

public class ControllerView extends dataStore implements Initializable {
    private String currentActivity = new String();
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField searchTextField;
    @FXML
    private TextField textField;

    // Event handler for ListView onKeyPressed event
    @FXML
    private void checkEnterListView(ActionEvent event) {
        System.out.println("abc");
        // Handle the event
    }

    // Event handler for JFXButton onAction event
    @FXML
    private void selectFirst(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void selectPrevious(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void selectNext(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void selectLast(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void clearSelection(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void detailModel(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void handleListViewDoubleClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Switch to b.fxml
                switchToFxmlDetail(selectedItem);
            }
        }
    }

    private void switchToFxmlDetail(String selectedItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/detail.fxml"));
            Parent root = loader.load();
            ControllerDetail detailController = loader.getController();
            detailController.setData(selectedItem, currentActivity);
            Stage stage = (Stage) listView.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    // Event handler for searching the character
    @FXML
    private void searchCharacter(ActionEvent event) {
        try {
            if (character.isEmpty()) {
                characterNKS objs = new characterNKS();
                character = objs.display();
            }
            // Create an ObservableList from the ArrayList
            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (characterNKS cha : character) {
                observableList.add(cha.getName());
            }
            listView.setItems(observableList);
            currentActivity = "characters";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    // Event handler for searching the dynasty
    @FXML
    private void searchDynasty(ActionEvent event) {
        // Handle the event
        try {
            if (dynastiesArr.isEmpty()) {
                dynasty objs = new dynasty();
                dynastiesArr = objs.display();
            }
            // Create an ObservableList from the ArrayList
            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (dynasty cha : dynastiesArr) {
                observableList.add(cha.getName());
            }
            listView.setItems(observableList);
            currentActivity = "dynasty";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // Event handler for searching the event
    @FXML
    private void searchEvent(ActionEvent event) {
        // Handle the event
        try {
            listView.setVisible(true);
            if (eventArr.isEmpty()) {
                eventnks objs = new eventnks();
                eventArr = objs.display();
            }
            // Create an ObservableList from the ArrayList
            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (eventnks cha : eventArr) {
                observableList.add(cha.getName());
            }
            listView.setItems(observableList);
            currentActivity = "event";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // Event handler for searching the festival
    @FXML
    private void searchFestival(ActionEvent event) {
        // Handle the event
        try {
            if (festivalsArr.isEmpty()) {
                festival objs = new festival();
                festivalsArr = objs.display();
            }
            // Create an ObservableList from the ArrayList
            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (festival cha : festivalsArr) {
                observableList.add(cha.getName());
            }
            listView.setItems(observableList);
            currentActivity = "festival";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    // Event handler for searching the place
    @FXML
    private void searchPlace(ActionEvent event) {
        try {
            diTichTrenVietnam ditich = new diTichTrenVietnam();
            ditichVN = ditich.display();
            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (diTichTrenVietnam diti : ditichVN) {
                observableList.add(diti.getName());
            }
            listView.setItems(observableList);
            currentActivity = "ditichvietnam";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Event handler for searching based on the text field
    @FXML
    private void searchButton(ActionEvent event) {
        System.out.print(searchTextField.getText());
    }

    // Event handler for handling key press in the text field
    @FXML
    private void handleKeyPress(KeyEvent event) {
        String search = new String();
        if (event.getCode() != KeyCode.ENTER) {
            search = searchTextField.getText();
            if (currentActivity == "characters") {
                characterNKS charac = new characterNKS();
                character = charac.search(search);
                ObservableList<String> observableList = FXCollections.observableArrayList();
                for (characterNKS cha : character) {
                    observableList.add(cha.getName());
                }
                listView.setItems(observableList);
            } else if (currentActivity == "ditichvietnam") {
                diTichTrenVietnam ditich = new diTichTrenVietnam();
                ditichVN = ditich.search(search);
                ObservableList<String> observableList = FXCollections.observableArrayList();
                for (diTichTrenVietnam diti : ditichVN) {
                    observableList.add(diti.getName());
                }
                listView.setItems(observableList);
            }
        }
    }

    // Event handler for refreshing the search text field
    @FXML
    private void refreshSearchTextField(ActionEvent event) {
        // Handle the event
    }

    // Event handler for handling click on search suggestions
    @FXML
    private void clickSuggestion(ActionEvent event) {
        // Handle the event
    }

    @FXML
    private void handleTextFieldAction(ActionEvent event) {

    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        // listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
        //     @Override
        //     public void handle(MouseEvent arg0) {
        //         if (arg0.getClickCount() == 2) {
        //             System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
        //             String selectedItem = listView.getSelectionModel().getSelectedItem();
        //             if (selectedItem != null) {

        //             }
        //         }
        //     }
        // });
    }

}
