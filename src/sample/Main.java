package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    final static String itemA = "A";
    final static String itemB = "B";
    final static String itemC = "F";
    @Override
    public void start(Stage stage) throws IOException {
        /*final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setTitle("Summary");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Item");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(2, itemA));
        series1.getData().add(new XYChart.Data(20, itemB));
        series1.getData().add(new XYChart.Data(10, itemC));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(50, itemA));
        series2.getData().add(new XYChart.Data(41, itemB));
        series2.getData().add(new XYChart.Data(45, itemC));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(45, itemA));
        series3.getData().add(new XYChart.Data(44, itemB));
        series3.getData().add(new XYChart.Data(18, itemC));

        Scene scene = new Scene(bc, 800, 600);
        bc.setAnimated(true);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();*/


        Parent root = FXMLLoader.load(getClass().getResource("qView.fxml"));
        stage.setTitle("Miss USA Contest 2006");
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
