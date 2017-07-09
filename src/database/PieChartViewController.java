package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;

/**
 * Visualisierung der Daten in einem Kreisdiagramm
 */
public class PieChartViewController implements Initializable {

    @FXML
    PieChart pieChart;

    @FXML
    Label question;

    private String q;
    private ArrayList<Info_Storage> list;

    PieChartViewController(ArrayList<Info_Storage> list, String q) {
        this.list = list;
        this.q = q;
    }

    /**
     * Liest die Daten aus der ArrayList und fügt sie dem Diagramm hinzu
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        question.setText(q);

        for (Info_Storage info_storage : list) pieChart.getData().add(new PieChart.Data(info_storage.getKey(), info_storage.getValue()));

        final Label caption = new Label("zeze");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());

                caption.setText(String.valueOf(data.getPieValue()));
                caption.setVisible(true);
            });
        }
    }
}
