package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Miss USA Contest 2006");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

        /*stage.setTitle("Line Chart Sample");
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String,Number> lineChart =
                new LineChart<>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data("03-07", 7));
        series.getData().add(new XYChart.Data("03-27", 6));
        series.getData().add(new XYChart.Data("03-28", 5));
        series.getData().add(new XYChart.Data("04-04", 5));
        series.getData().add(new XYChart.Data("04-08", 8));
        series.getData().add(new XYChart.Data("04-10", 9));
        series.getData().add(new XYChart.Data("04-14", 10));
        series.getData().add(new XYChart.Data("04-16", 7));
        series.getData().add(new XYChart.Data("04-18", 6));
        series.getData().add(new XYChart.Data("04-19", 5));
        series.getData().add(new XYChart.Data("04-21", 59));
        series.getData().add(new XYChart.Data("04-22", 161));
        series.getData().add(new XYChart.Data("04-23", 40));
        series.getData().add(new XYChart.Data("04-24", 35));
        series.getData().add(new XYChart.Data("04-25", 28));
        series.getData().add(new XYChart.Data("04-26", 8));
        series.getData().add(new XYChart.Data("04-27", 5));
        series.getData().add(new XYChart.Data("05-03", 7));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
