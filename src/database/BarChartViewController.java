package database;

import java.net.URL;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * Visualisierung der Daten in einem Balkendiagramm
 */
public class BarChartViewController implements Initializable {

    @FXML
    NumberAxis yAxis;

    @FXML
    BarChart<String, Number> barChart;

    @FXML
    CategoryAxis xAxis;

    @FXML
    Label question;

    private String xName, yName, q, seriesName;
    private ArrayList<Info_Storage> list;
    XYChart.Series series;

    BarChartViewController(ArrayList<Info_Storage> list, String q, String xName, String yName, String seriesName) {
        this.list = list;
        this.xName = xName;
        this.yName = yName;
        this.q = q;
        this.seriesName = seriesName;
    }

    /**
     * Liest die Daten aus der ArrayList und fügt sie dem Diagramm hinzu
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        series = new XYChart.Series();
        series.setName(seriesName);
        xAxis.setLabel(xName);
        yAxis.setLabel(yName);
        question.setText(q);

        for (Info_Storage info_storage : list) series.getData().add(new XYChart.Data(info_storage.getKey(), info_storage.getValue()));

        barChart.setAnimated(true);
        barChart.getData().addAll(series);
    }

}
