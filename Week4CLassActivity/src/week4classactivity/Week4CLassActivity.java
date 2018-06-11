package week4classactivity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Week4CLassActivity extends Application {
    Button rectbtn = new Button("Rect");
    Button circbtn = new Button("Circle");
    ToggleGroup grp = new ToggleGroup();
    Pane drawPane = new Pane();
    BorderPane bPane = new BorderPane();
    HBox butBox = new HBox(5);
    
    @Override
    public void start(Stage primaryStage) {
        try{
        Shape rect = new Rectangle(60,60,20, 30);
        Shape circ = new Circle(50, 50, 20);
        rectbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                bPane.getChildren().add(rect);
            }
        });
        circbtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                bPane.getChildren().add(circ);
            }
        });
              
        butBox.getChildren().add(rectbtn);
        butBox.getChildren().add(circbtn);
        
        bPane.setTop(butBox);
        bPane.setCenter(drawPane);
        
        Scene scene = new Scene(bPane, 300, 250);
        primaryStage.setTitle("Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        catch(Exception ex)
        {
            System.out.println("Shape already drawn.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
