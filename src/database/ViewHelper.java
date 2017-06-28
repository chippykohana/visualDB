package database;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Die Klasse ViewHelper besitzt statische Methoden für das Anzeigen von GUI-Elementen
 * in einen zusaetzlichen Fenster.
 *
 * @author beuth
 */
public class ViewHelper {




    /**
     * Methode erzeugt ein LineChart
     * @param list beinhaltet Daten aus der Datenbank
     * @param q Frage String
     * @param xName x-Achsenbeschriftung
     * @param yName y-Achsenbeschriftung
     * @param seriesName Legende
     */
    public static void showDataLine(ArrayList<Info_Storage> list, String q, String xName, String yName, String seriesName) {
        URL location = new ViewHelper().getClass().getResource("lineChartView.fxml");
        Initializable controller = new LineChartViewController(list, q, xName, yName, seriesName);
        showView(controller, location);
    }

    /**
     * Methode erzeugt ein PieChart
     * @param list beinhaltet Daten aus der Datenbank
     * @param q Frage String
     */
    public static void showDataPie(ArrayList<Info_Storage> list, String q) {
        URL location = new ViewHelper().getClass().getResource("pieChartView.fxml");
        Initializable controller = new PieChartViewController(list, q);
        showView(controller, location);
    }

    /**
     * Methode erzeugt ein BarChart
     * @param list beinhaltet Daten aus der Datenbank
     * @param q Frage String
     * @param xName x-Achsenbeschriftung
     * @param yName y-Achsenbeschriftung
     * @param seriesName Legende
     */
    public static void showDataBar(ArrayList<Info_Storage> list, String q, String xName, String yName, String seriesName) {
        URL location = new ViewHelper().getClass().getResource("barChartView.fxml");
        Initializable controller = new BarChartViewController(list, q, xName, yName, seriesName);
        showView(controller, location);
    }

    public static void showDataTable(ArrayList<Info_Storage> list, String q) {
        URL location = new ViewHelper().getClass().getResource("tableViewView.fxml");
        Initializable controller = new TableViewViewController(list, q);
        showView(controller, location);
    }

    /**
     * Laedt eine neue Scene in einer Stage mit dem übergebenen Controller und
     * dem übergebenen FXML-Dokument
     *
     * @param controller Der für die GUI zu verwendende Controller
     * @param location   Die URL der FXML-Datei mit der GUI-Beschreibung
     */
    public static void showView(Initializable controller, URL location) {
        Stage editStage = new Stage(StageStyle.UTILITY);
        editStage.setTitle("");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setController(controller);
        try {
            Pane myPane = (Pane) fxmlLoader.load();
            Scene myScene = new Scene(myPane);
            editStage.setScene(myScene);
            editStage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
