/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author beuth
 */
public class BarChartViewController implements Initializable {

    @FXML
    NumberAxis yAxis;

    @FXML
    BarChart<?, ?> barChart;

    @FXML
    CategoryAxis xAxis;

    @FXML
    Label question;

    private String xName, yName, q, seriesName;
    private ArrayList<Info_Storage> list;
    XYChart.Series series;

    public BarChartViewController(ArrayList<Info_Storage> list, String q, String xName, String yName, String seriesName) {
        this.list = list;
        this.xName = xName;
        this.yName = yName;
        this.q = q;
        this.seriesName = seriesName;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        series = new XYChart.Series();
        series.setName(seriesName);
        xAxis.setLabel(xName);
        yAxis.setLabel(yName);
        question.setText(q);

        for (Info_Storage info_storage : list) series.getData().add(new XYChart.Data(info_storage.getKey(), info_storage.getValue()));

        barChart.getData().addAll(series);
    }

}
