package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("qView.fxml"));
        stage.setTitle("Miss USA Contest 2006");
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
