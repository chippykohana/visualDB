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
    private ArrayList<Info_Storage> list;

    public PieChartViewController(ArrayList<Info_Storage> list, String q) {
        this.list = list;
        this.q = q;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        question.setText(q);

        for (Info_Storage info_storage : list) pieChart.getData().add(new PieChart.Data(info_storage.getKey(), info_storage.getValue()));
    }
}
