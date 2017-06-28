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
 * Created by nhunimuni on 28.06.17.
 */
public class TableViewViewController implements Initializable {

    @FXML
    private TableView<Info_Storage> table;
    @FXML
    private TableColumn<Info_Storage, String> website;
    @FXML
    private TableColumn<Info_Storage, Integer> clicks;
    @FXML
    private Label question;

    private ObservableList<Info_Storage> data;
    private String q;
    private ArrayList<Info_Storage> list;

    public TableViewViewController(ArrayList<Info_Storage> list, String q) {
        this.list = list;
        this.q = q;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        question.setText(q);

        data = FXCollections.observableArrayList();
        initTable();
    }

    private void initTable() {
        website.setCellValueFactory(new PropertyValueFactory<>("Website"));
        clicks.setCellValueFactory(new PropertyValueFactory<>("Clicks"));

        for (Info_Storage info_storage : list) {
            data.add(info_storage);
        }
        table.setItems(data);
    }

}
