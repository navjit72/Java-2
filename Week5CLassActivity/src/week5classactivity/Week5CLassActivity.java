package week5classactivity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Week5CLassActivity extends Application {

    Button rectbtn = new Button("Rect");
    Button circbtn = new Button("Circle");
    ToggleGroup grp = new ToggleGroup();
    Pane drawPane = new Pane();
    BorderPane bPane = new BorderPane();
    HBox butBox = new HBox(5);
    Shape dropShape = null;
    double mouseX, mouseY, shapeX, shapeY;

    @Override
    public void start(Stage primaryStage) {
        try {
            //Shape rect = new Rectangle(20, 30);
            //Shape circ = new Circle(20);
//        rect.setTranslateX(50);
//        rect.setTranslateY(50);
//        circ.setTranslateX(30);
//        circ.setTranslateY(30);
            rectbtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    dropShape = new Rectangle(40, 30);
                }
            });
            circbtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    dropShape = new Circle(50);
                }
            });

            drawPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (dropShape != null) {
                        dropShape.setTranslateX(event.getX());
                        dropShape.setTranslateY(event.getY());
                        drawPane.getChildren().add(dropShape);
                        dropShape.setOnMouseDragged(new MouseDragHandler());
                        dropShape.setOnMousePressed(new MousePressHandler());
                        dropShape = null;
                    }
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
        } catch (Exception ex) {
            System.out.println("Shape already drawn.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    class MouseDragHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            double dx = event.getSceneX()-mouseX;
            double dy = event.getSceneY()-mouseY;
            ((Shape)event.getTarget()).setTranslateX(shapeX + dx);
            ((Shape)event.getTarget()).setTranslateY(shapeY + dy);
        }

    }
    
    class MousePressHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
            shapeX = ((Shape) event.getTarget()).getTranslateX();
            shapeY = ((Shape) event.getTarget()).getTranslateY();
        }
        
    }

}
