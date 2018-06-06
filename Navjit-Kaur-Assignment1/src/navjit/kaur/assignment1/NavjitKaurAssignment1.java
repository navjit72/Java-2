/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navjit.kaur.assignment1;

import com.sun.javafx.scene.control.skin.LabeledText;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author NAVJIT
 */
public class NavjitKaurAssignment1 extends Application {

    GridPane grid = new GridPane();
    Label title = new Label("Employee Expense Form");
    Label name = new Label("Employee");
    Label id = new Label("ID");
    Label date = new Label("Date");
    Label destination = new Label("Destination");
    Label category = new Label("Category");
    Label description = new Label("Description");
    Label amount = new Label("Amount");
    Label total = new Label("Total");

    TextField txtName = new TextField();
    TextField txtId = new TextField();
    DatePicker txtDate = new DatePicker();
    TextField txtDest = new TextField();
    TextField txtCategory1 = new TextField();
    TextField txtCategory2 = new TextField();
    TextField txtCategory3 = new TextField();
    TextField txtCategory4 = new TextField();
    TextField txtDescription1 = new TextField();
    TextField txtDescription2 = new TextField();
    TextField txtDescription3 = new TextField();
    TextField txtDescription4 = new TextField();
    TextField txtAmount1 = new TextField();
    TextField txtAmount2 = new TextField();
    TextField txtAmount3 = new TextField();
    TextField txtAmount4 = new TextField();
    TextField txtTotalAmount = new TextField();

    Button submit = new Button("Submit");
    Pane pane = new Pane();


    @Override
    public void start(Stage primaryStage) {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        grid.add(title, 0, 0);
        grid.add(name, 0, 1);
        grid.add(txtName, 1, 1);
        grid.add(id, 0, 2);
        grid.add(txtId, 1, 2);
        grid.add(date, 0, 3);
        grid.add(txtDate, 1, 3);
        grid.add(destination, 0, 4);
        grid.add(txtDest, 1, 4);
        grid.add(category, 0, 5);
        grid.add(description, 1, 5);
        grid.add(amount, 2, 5);
        grid.add(txtCategory1, 0, 6);
        grid.add(txtCategory2, 0, 7);
        grid.add(txtCategory3, 0, 8);
        grid.add(txtCategory4, 0, 9);
        grid.add(txtDescription1, 1, 6);
        grid.add(txtDescription2, 1, 7);
        grid.add(txtDescription3, 1, 8);
        grid.add(txtDescription4, 1, 9);
        grid.add(txtAmount1, 2, 6);
        grid.add(txtAmount2, 2, 7);
        grid.add(txtAmount3, 2, 8);
        grid.add(txtAmount4, 2, 9);
        grid.add(submit, 0, 10);
        grid.add(total, 1, 10);
        grid.add(txtTotalAmount, 2, 10);

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               
                ObservableList<PieChart.Data> pieChartData
                        = FXCollections.observableArrayList(
                                new PieChart.Data("Grapefruit", 13),
                                new PieChart.Data("Oranges", 25),
                                new PieChart.Data("Plums", 10),
                                new PieChart.Data("Pears", 22),
                                new PieChart.Data("Apples", 30));
                PieChart chart = new PieChart(pieChartData);
                Group group= new Group(chart);
                chart.setLabelLineLength(10);
                chart.setLegendSide(Side.LEFT);
                pane.getChildren().add(group);
            }
        });
        pane.getChildren().add(grid);
        

        Scene scene = new Scene(pane, 700, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
