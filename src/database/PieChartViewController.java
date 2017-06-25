package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.*;

/**
 * Created by young on 25.06.2017.
 */
public class PieChartViewController implements Initializable {

    @FXML
    PieChart pieChart;

    @FXML
    Label question;

    private String q;
    private HashMap<String, Integer> list;

    public PieChartViewController(HashMap<String, Integer> list, String q) {
        this.list = list;
        this.q = q;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        question.setText(q);

        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue();
            pieChart.getData().add(new PieChart.Data(key, val));
        }
    }
}
