package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
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
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private Label question;

    private String xName, yName, q, seriesName;
    private HashMap<String, Integer> list;
    XYChart.Series series;

    public LineChartViewController(HashMap<String, Integer> list, String q, String yName, String xName, String seriesName) {
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

        Set set = list.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            series.getData().add(new XYChart.Data(me.getKey(), me.getValue()));
        }
    }
}
