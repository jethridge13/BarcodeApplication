/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcodeapplication;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Joshua
 */
public class BarcodeUI {

    private BorderPane mainPane;
    private int paneWidth;
    private int paneHeight;
    private final int defaultPaneWidth = 600;
    private final int defaultPaneHeight = 800;
    private final Insets marginlessInsets = new Insets(5, 5, 5, 5);
    private Stage primaryStage;
    private final BarcodeEventHandler eventHandler;
    
    private HBox northToolbar;
    
    private final String createNewCodeString = "Create New Code";
    private final String readNewCodeString = "Read New Code";
    private final String exitButtonString = "Exit";
    private final String exitText = "Exit?";

    public BarcodeUI() {
        initMainPane();
        initMainScreen();
        eventHandler = new BarcodeEventHandler(this);
    }

    public BorderPane getMainPane() {
        return this.mainPane;
    }

    private void initMainPane() {
        mainPane = new BorderPane();
        paneWidth = defaultPaneWidth;
        paneHeight = defaultPaneHeight;
        mainPane.resize(paneWidth, paneHeight);
        mainPane.setPadding(marginlessInsets);
    }

    private void initMainScreen() {
        northToolbar = new HBox();
        northToolbar.setAlignment(Pos.TOP_LEFT);
        northToolbar.setSpacing(10.0);
        ArrayList<String> buttonOptions = new ArrayList<>();
        buttonOptions.add(createNewCodeString);
        buttonOptions.add(readNewCodeString);
        buttonOptions.add(exitButtonString);
        for(int i = 0; i < buttonOptions.size(); i++){
            String button = buttonOptions.get(i);
            Button toolbarButton = new Button(button);
            toolbarButton.setOnAction((ActionEvent event) -> {
                eventHandler.respondToButtonPress(button);
            });
            northToolbar.getChildren().add(toolbarButton);
        }
        mainPane.setTop(northToolbar);
    }
    
    public void setStage(Stage stage){
        primaryStage = stage;
    }

    void exit() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        BorderPane exitPane = new BorderPane();
        Button yesButton = new Button("Yes");
        yesButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        Button noButton = new Button("No");
        noButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox exitBox = new HBox();
        exitBox.getChildren().add(yesButton);
        exitBox.getChildren().add(noButton);
        exitBox.setSpacing(10.0);
        exitBox.setAlignment(Pos.CENTER);
        Text text = new Text(exitText);
        exitPane.setBottom(exitBox);
        exitPane.setCenter(text);
        Scene scene = new Scene(exitPane, 200, 100);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    void newRead() {
        System.out.println("Method not yet supported.");
        //To change body of generated methods, choose Tools | Templates.
    }

    void newCode() {
        System.out.println("Method not yet supported.");
        //To change body of generated methods, choose Tools | Templates.
    }

}
