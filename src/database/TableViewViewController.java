package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Visualisierung der Daten in einer Tabelle
 */
public class TableViewViewController implements Initializable {

    @FXML
    TableView<Info_Storage> table;
    @FXML
    TableColumn<Info_Storage, String> website;
    @FXML
    TableColumn<Info_Storage, Integer> clicks;
    @FXML
    Label question;

    private ObservableList<Info_Storage> data;
    private String q;
    private ArrayList<Info_Storage> list;

    TableViewViewController(ArrayList<Info_Storage> list, String q) {
        this.list = list;
        this.q = q;
    }

    /**
     * Liest die Daten aus der ArrayList und fügt sie dem Diagramm hinzu
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        question.setText(q);
        data = FXCollections.observableArrayList();

        website.setCellValueFactory(new PropertyValueFactory<>("key"));
        clicks.setCellValueFactory(new PropertyValueFactory<>("value"));

        data.addAll(list);
        table.setItems(data);
    }

}
