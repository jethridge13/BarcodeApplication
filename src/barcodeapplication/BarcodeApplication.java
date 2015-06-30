/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barcodeapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Joshua
 */
public class BarcodeApplication extends Application {
    static final String title = "CSC Barcode Reader";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        BarcodeUI base = new BarcodeUI();
        BorderPane mainPane = base.getMainPane();
        base.setStage(primaryStage);
        Scene scene = new Scene(mainPane, mainPane.getWidth(), mainPane.getHeight());
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
