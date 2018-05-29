package week4_lab2.navjit.kaur;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Week4_Lab2NavjitKaur extends Application {

    GridPane grid = new GridPane();
    Label l1 = new Label("Customer Entry Application");
    Label lname = new Label("Name:");
    Label laddr = new Label("Address:");
    Label lphone = new Label("Phone:");
    TextField txtName = new TextField();
    TextField txtAddr = new TextField();
    TextField txtPhone = new TextField();
    Button btnSave = new Button("Save");
    Button btnQuit = new Button("Quit without saving");

    @Override
    public void start(Stage primaryStage) {
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        grid.add(l1, 0, 0);
        grid.add(lname, 0, 1);
        grid.add(txtName, 1, 1);
        grid.add(laddr, 0, 2);
        grid.add(txtAddr, 1, 2);
        grid.add(lphone, 0, 3);
        grid.add(txtPhone, 1, 3);
        grid.add(btnSave, 0, 4);
        grid.add(btnQuit, 1, 4);

        btnSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                PrintWriter fw = null;
                try {
                    fw = new PrintWriter("customer.txt");
                    fw.print("Name : "+txtName.getText());
                    fw.println();
                    fw.print("Address : "+txtAddr.getText());
                    fw.println();
                    fw.print("Phone : "+txtPhone.getText());
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    fw.close();
                }
                txtName.clear();
                txtAddr.clear();
                txtPhone.clear();
            }

        });
        
            btnQuit.setOnAction (new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                primaryStage.close();
                }
            });

        Scene scene = new Scene(grid, 300, 250);

            primaryStage.setTitle ("Customer Entry Application");
            primaryStage.setScene (scene);

            primaryStage.show ();
        }
        /**
         * @param args the command line arguments
         */

    public static void main(String[] args) {
        launch(args);
    }

}
