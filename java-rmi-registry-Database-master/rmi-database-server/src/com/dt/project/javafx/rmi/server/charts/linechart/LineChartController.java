package com.dt.project.javafx.rmi.server.charts.linechart;

import com.dt.project.javafx.rmi.server.utilities.InscriptionRe;
import com.dt.project.javafx.rmi.server.utilities.UnivStat;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class LineChartController implements Initializable {

    @FXML
    private LineChart<String, Integer> lineChart;

    XYChart.Series[] series;
    private ObservableList<UnivStat> ListStudent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List a = new ArrayList();
        ObservableList<String> List = FXCollections.observableList(a);
        ListStudent = InscriptionRe.UnivStat();
        int k = 0;
        for (UnivStat univStat : ListStudent) {
            if (!List.contains(univStat.getCode())) {
                List.add(univStat.getCode());
                k++;
            }
        }

        List d = new ArrayList();
        ObservableList<LocalDate> ListD = FXCollections.observableList(d);
        int da = 0;
        for (UnivStat univStat : ListStudent) {
            if (!ListD.contains(univStat.getDate_Res())) {
                ListD.add(univStat.getDate_Res());
                da++;
            }
        }

        series = new XYChart.Series[k];

        //defining a series
        int j = 0;
        for (String univStat : List) {
            series[j] = new XYChart.Series();
            series[j].setName(univStat);
            j++;
        }

        // Initialize series
        for (int i = 0; i < k; i++) {
            for (LocalDate localDate : ListD) {
                series[i].getData().add(new XYChart.Data<>(localDate.toString(), 0));
            }
        }

        for (int i = 0; i < k; i++) {
            int b = 0;
            for (UnivStat localDate : ListStudent) {
                if (List.get(i) == null ? localDate.getCode() == null : List.get(i).equals(localDate.getCode())) {
                    series[i].getData().set(b, new XYChart.Data<>(localDate.getDate_Res().toString(), localDate.getCount()));
                    b++;
                }
            }
        }

        for (XYChart.Series sery : series) {
            lineChart.getData().add(sery);
        }
    }

}
