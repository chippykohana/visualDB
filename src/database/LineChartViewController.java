package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

/**
 * Created by Nyoung on 26.06.2017.
 */
public class LineChartViewController implements Initializable {

    @FXML
    NumberAxis yAxis;

    @FXML
    CategoryAxis xAxis;

    @FXML
    LineChart<String, Number> lineChart;

    @FXML
    Label question;

    private String xName, yName, q, seriesName;
    private ArrayList<Info_Storage> list;
    XYChart.Series series;

    public LineChartViewController(ArrayList<Info_Storage> list, String q, String xName, String yName, String seriesName) {
        this.xName = xName;
        this.yName = yName;
        this.q = q;
        this.list = list;
        this.seriesName = seriesName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        series = new XYChart.Series();
        series.setName(seriesName);
        question.setText(q);
        xAxis.setLabel(xName);
        yAxis.setLabel(yName);

        for (Info_Storage info_storage : list) series.getData().add(new XYChart.Data(info_storage.getKey(), info_storage.getValue()));

        lineChart.getData().addAll(series);
    }
}
