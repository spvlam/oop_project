package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class View extends Application{

    @Override
    public void start(Stage primaryStage)throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
            Scene scen = new Scene(root);
            scen.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
            // System.out.print(root);
            primaryStage.setScene(scen);
            primaryStage.show();
        } catch (Exception e) {
        //    System.out.print("root");
            e.printStackTrace(); // Print the exception stack trace to the console
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
