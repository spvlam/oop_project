package view;

import controller.ControllerDetail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Detail extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detail.fxml"));
        Parent root = loader.load();
        // set css here
        // set data to controller of detail
        ControllerDetail detailController = loader.getController();
        detailController.setData("An Dương Vương","characters");
        Scene scen = new Scene(root);
        primaryStage.setScene(scen);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
