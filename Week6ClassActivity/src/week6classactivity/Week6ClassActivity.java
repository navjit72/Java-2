/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6classactivity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author NAVJIT
 */
public class Week6ClassActivity extends Application {
    Pane pane = new Pane();
    BorderPane bpane = new BorderPane();
    Shape shape = null;
    
    @Override
    public void start(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu menuShape = new Menu("Shape");
        menuBar.getMenus().add(menuShape);
        
        MenuItem rectMenu = new MenuItem("Rectangle");
        MenuItem circMenu = new MenuItem("Circle");
        menuShape.getItems().addAll(rectMenu,circMenu);
        
        rectMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shape = new Rectangle(60,60,20, 30);
                pane.getChildren().add(shape);
            }
        });
        
        circMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shape = new Circle(50, 50, 20);
                pane.getChildren().add(shape);
            }
        });
       
//        VBox vbox = new VBox(10);
//        vbox.getChildren().addAll(menuBar);
        bpane.setTop(menuBar);
        bpane.setCenter(pane);
        Scene scene = new Scene(bpane, 300, 250);
        scene.getStylesheets().add(Week6ClassActivity.class.getResource("draw.css").toExternalForm());
        pane.getStyleClass().add("pane");
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
