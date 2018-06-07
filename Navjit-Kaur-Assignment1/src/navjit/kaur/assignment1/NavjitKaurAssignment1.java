/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navjit.kaur.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author NAVJIT
 */
public class NavjitKaurAssignment1 extends Application {

    //Creating Controls
    Button submit = new Button("Submit");
    Pane pane = new Pane();
    Pane piePane = new Pane();
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
    ComboBox<String> categoryList1 = new ComboBox<>();
    ComboBox<String> categoryList2 = new ComboBox<>();
    ComboBox<String> categoryList3 = new ComboBox<>();
    ComboBox<String> categoryList4 = new ComboBox<>();
    TextField txtDescription1 = new TextField();
    TextField txtDescription2 = new TextField();
    TextField txtDescription3 = new TextField();
    TextField txtDescription4 = new TextField();
    TextField txtAmount1 = new TextField();
    TextField txtAmount2 = new TextField();
    TextField txtAmount3 = new TextField();
    TextField txtAmount4 = new TextField();
    TextField txtTotalAmount = new TextField();

    double am1 = 0, am2 = 0, am3 = 0, am4 = 0;

    //method to calculate total amount.
    private double CalculateTotal() {
        if (txtAmount1.getText().isEmpty()) {
            am1 = 0;
        } else {
            am1 = Double.parseDouble(txtAmount1.getText());
        }
        if (txtAmount2.getText().isEmpty()) {
            am2 = 0;
        } else {
            am2 = Double.parseDouble(txtAmount2.getText());
        }
        if (txtAmount3.getText().isEmpty()) {
            am3 = 0;
        } else {
            am3 = Double.parseDouble(txtAmount3.getText());
        }
        if (txtAmount4.getText().isEmpty()) {
            am4 = 0;
        } else {
            am4 = Double.parseDouble(txtAmount4.getText());
        }

        return am1 + am2 + am3 + am4;
    }

    //method to fill all the comboboxes with 4 categories.
    private void FillComboBox() {
        categoryList1.getItems().addAll("Food", "Transportation", "Lodging", "Other");
        categoryList2.getItems().addAll("Food", "Transportation", "Lodging", "Other");
        categoryList3.getItems().addAll("Food", "Transportation", "Lodging", "Other");
        categoryList4.getItems().addAll("Food", "Transportation", "Lodging", "Other");
    }

    //method to add all controls in grid pane.
    private void PreparePane() {
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
        grid.add(categoryList1, 0, 6);
        grid.add(categoryList2, 0, 7);
        grid.add(categoryList3, 0, 8);
        grid.add(categoryList4, 0, 9);
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
    }

    //method to read data from employee_info.txt file.
    private void ReadFile() {
        File file = new File("employee_info.txt");
        try {
            Scanner input = new Scanner(file);
            String str[] = new String[2];
            int i = 0;
            while (input.hasNext()) {
                str[i] = input.nextLine();
                i++;
            }

            txtId.setText(str[0]);
            txtName.setText(str[1]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //method to write all the information into expenses.txt file.
    private void WriteFile() {
        PrintWriter fw = null;
        try {
            fw = new PrintWriter("expenses.txt");
            fw.print("Name : " + txtName.getText());
            fw.println();
            fw.print("ID : " + txtId.getText());
            fw.println();
            fw.print("Date : " + txtDate.getValue());
            fw.println();
            fw.print("Destination : " + txtDest.getText());
            fw.println();
            fw.print("Category 1: ");
            fw.println();
            fw.print(categoryList1.getValue() + " :- "
                    + txtDescription1.getText() + " , Amount : " + txtAmount1.getText());
            fw.println();
            fw.print("Category 2: ");
            fw.println();
            fw.print(categoryList2.getValue() + " :- "
                    + txtDescription2.getText() + " , Amount : " + txtAmount2.getText());
            fw.println();
            fw.print("Category 3: ");
            fw.println();
            fw.print(categoryList3.getValue() + " :- "
                    + txtDescription3.getText() + " , Amount : " + txtAmount3.getText());
            fw.println();
            fw.print("Category 4: ");
            fw.println();
            fw.print(categoryList4.getValue() + " :- "
                    + txtDescription4.getText() + " , Amount : " + txtAmount4.getText());
            fw.println();
            fw.print("Total Amount : " + txtTotalAmount.getText());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            fw.close();
        }

    }

    //method to create the piechart according to the filled data.
    private void CreatePieChart(Stage stage) {
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data(categoryList1.getValue(), am1),
                        new PieChart.Data(categoryList2.getValue(), am2),
                        new PieChart.Data(categoryList3.getValue(), am3),
                        new PieChart.Data(categoryList4.getValue(), am4));
        PieChart chart = new PieChart(pieChartData);
        piePane.getChildren().add(chart);
        piePane.setTranslateX(300);
        piePane.setTranslateY(0);
        piePane.setPrefSize(10, 10);
        piePane.setBorder(1);
        
        chart.setLegendVisible(false);
    }

    //method to clear all the fields and refresh the form.
    private void RefreshPage() {
        txtDate.setValue(null);
        txtDest.clear();
        txtAmount1.clear();
        txtAmount2.clear();
        txtAmount3.clear();
        txtAmount4.clear();
        txtDescription1.clear();
        txtDescription2.clear();
        txtDescription3.clear();
        txtDescription4.clear();
        categoryList1.setValue(null);
        categoryList2.setValue(null);
        categoryList3.setValue(null);
        categoryList4.setValue(null);
    }

    @Override
    public void start(Stage primaryStage) {
        FillComboBox();
        PreparePane();
        ReadFile();
        txtAmount1.textProperty().addListener((observable) -> {
            txtTotalAmount.setText(String.valueOf(CalculateTotal()));
        });

        txtAmount2.textProperty().addListener((observable) -> {
            txtTotalAmount.setText(String.valueOf(CalculateTotal()));
        });

        txtAmount3.textProperty().addListener((observable) -> {
            txtTotalAmount.setText(String.valueOf(CalculateTotal()));
        });

        txtAmount4.textProperty().addListener((observable) -> {
            txtTotalAmount.setText(String.valueOf(CalculateTotal()));
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                WriteFile();
                CreatePieChart(primaryStage);
                RefreshPage();
            }
        });
        pane.getChildren().add(grid);
        pane.getChildren().add(piePane);

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
