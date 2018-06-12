/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6tableview;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author NAVJIT
 */
public class Week6TableView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TableView<Pet> tableView = new TableView<>();
        ObservableList<Pet> data = FXCollections.observableArrayList(
                new Pet("Marshall", "dog", "black"),
                new Pet("Candy", "Cat", "blue"),
                new Pet("Fishy", "Fish", "golden"));
        tableView.setItems(data);
        
        TableColumn petNameColumn = new TableColumn("Name");
        petNameColumn.setMinWidth(100);
        petNameColumn.setCellValueFactory(
        new PropertyValueFactory<Pet, String>("name"));
        
        TableColumn petSpeciesColumn = new TableColumn("Species");
        petSpeciesColumn.setMinWidth(100);
        petSpeciesColumn.setCellValueFactory(
        new PropertyValueFactory<Pet, String>("species"));
        
        TableColumn petColorColumn = new TableColumn("Color");
        petColorColumn.setMinWidth(100);
        petColorColumn.setCellValueFactory(
        new PropertyValueFactory<Pet, String>("color"));
        
        tableView.getColumns().addAll(petNameColumn, petSpeciesColumn,
      petColorColumn);
        
        Pane pane = new Pane();
        pane.getChildren().add(tableView);
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Pet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Pet{
    public SimpleStringProperty name = new SimpleStringProperty();
    public SimpleStringProperty species = new SimpleStringProperty();
    public SimpleStringProperty color = new SimpleStringProperty();
    
    private Pet(String nm, String sp, String col)
    {
        name.setValue(nm);
        species.setValue(sp);
        color.setValue(col);
    }
    public String getName()
    {
        return name.getValue();
    }
    public void setName(String name)
    {
        this.name.setValue(name);
    }
    public String getSpecies()
    {
        return species.getValue();
    }
    public void setSpecies(String species)
    {
        this.species.setValue(species);
    }
    public String getColor()
    {
        return color.getValue();
    }
    public void setColor(String color)
    {
        this.color.setValue(color);
    }
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
