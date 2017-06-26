package sample;

import database.DB_Con;
import database.SQL_States;
import database.ViewHelper;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button aufg1;
    public Button aufg2;
    public Button aufg3;
    public Button aufg4;
    public Button aufg5;
    public Button aufg6;
    public Button aufg7;
    public Button aufg8;
    public Button aufg9;

    DB_Con db_con;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db_con = new DB_Con();
        try {
            db_con.openDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        aufg1.setOnAction(event -> exeAufg1());
        aufg2.setOnAction(event -> exeAufg2());
        aufg3.setOnAction(event -> exeAufg3());
        aufg4.setOnAction(event -> exeAufg4());
        aufg5.setOnAction(event -> exeAufg5());
        aufg6.setOnAction(event -> exeAufg6());
        aufg7.setOnAction(event -> exeAufg7());
        aufg8.setOnAction(event -> exeAufg8());
        aufg9.setOnAction(event -> exeAufg9());
    }

    private void exeAufg9() {
        System.out.println(SQL_States.PARTIC_AFTER_CONTEST);
        db_con.print(SQL_States.PARTIC_AFTER_CONTEST);
        ViewHelper.showDataBar(db_con.getList(),
                "Welche Teilnehmerinnen wurden nach der Verleihung am meisten gesucht?",
                "Participant",
                "Clicks",
                "Clicks after the contest");
    }

    private void exeAufg8() {
        System.out.println(SQL_States.PARTIC_BEFORE_CONTEST);
        db_con.print(SQL_States.PARTIC_BEFORE_CONTEST);
        ViewHelper.showDataBar(db_con.getList(),
                "Welche Teilnehmerinnen wurden vor der Verleihung am meisten gesucht?",
                "Participant",
                "Clicks",
                "Clicks before the contest");
    }

    private void exeAufg7() {
    }

    private void exeAufg6() {
    }

    private void exeAufg5() {
        System.out.println(SQL_States.DAYS_MOST_CLICKED);
        db_con.print(SQL_States.DAYS_MOST_CLICKED);
        ViewHelper.showDataLine(db_con.getList(),
                "An welchen Tagen wurden die meisten Anfragen zu unserem Thema gestellt?",
                "Date",
                "Clicks",
                "Searched for Miss USA");
    }

    private void exeAufg4() {
        System.out.println(SQL_States.NAME_OF_WINNER);
        db_con.print(SQL_States.NAME_OF_WINNER);
        ViewHelper.showDataPie(db_con.getList(),
                "Wie oft wurde gezielt nach dem Namen der Gewinnerin gesucht?");

    }

    private void exeAufg3() {

    }

    private void exeAufg2() {
        System.out.println(SQL_States.CLICKS_PER_MONTHS);
        db_con.print(SQL_States.CLICKS_PER_MONTHS);
        ViewHelper.showDataBar(db_con.getList(),
                "Wie häufig wurde nach dem \"Miss USA\" Wettbewerb gesucht zwischen März und Ende Mai?",
                "Month",
                "Clicks",
                "Clicks per Month");
    }

    private void exeAufg1() {
        System.out.println("test1");
    }
}
