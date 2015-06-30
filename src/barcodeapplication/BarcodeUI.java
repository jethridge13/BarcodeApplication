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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private final String yesText = "Yes";
    private final String noText = "No";
    private final String closeButtonString = "Close";
    private final String newReadText = "New Read";
    private final String fileNameText = "File Name: ";
    private final String fileTextFieldText = "File Name";
    private final String browseText = "Browse";
    private final String okText = "OK";
    private final String filePathText = "File Path: ";
    private final String filePathFieldText = "File Path";
    private final String codeReadText = "Code Read!";
    private final String invalidFileText = "That file is invalid!";
    private final String invalidFileTitle = "Invalid file!";
    
    private TextField fileName;
    private TextField filePathField;

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
        Button yesButton = new Button(yesText);
        yesButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        Button noButton = new Button(noText);
        noButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox exitBox = new HBox();
        exitBox.getChildren().add(yesButton);
        exitBox.getChildren().add(noButton);
        exitBox.setSpacing(10.0);
        exitBox.setAlignment(Pos.CENTER);
        exitBox.setPadding(marginlessInsets);
        Text text = new Text(exitText);
        exitPane.setBottom(exitBox);
        exitPane.setCenter(text);
        Scene scene = new Scene(exitPane, 200, 100);
        dialogStage.setScene(scene);
        dialogStage.setTitle(exitText);
        dialogStage.setResizable(false);
        dialogStage.show();
    }

    void newRead() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        BorderPane newReadPane = new BorderPane();
        //Middle
        VBox middle = new VBox();
        HBox middleBox = new HBox();
        Text fileText = new Text(fileNameText);
        fileName = new TextField(fileTextFieldText);
        Button browse = new Button(browseText);
        middleBox.getChildren().add(fileText);
        middleBox.getChildren().add(fileName);
        middleBox.getChildren().add(browse);
        middleBox.setSpacing(10.0);
        middleBox.setAlignment(Pos.CENTER);
        middle.getChildren().add(middleBox);
        Button ok = new Button(okText);
        ok.setOnAction((ActionEvent event) -> {
            eventHandler.respondToButtonPress("newRead");
            dialogStage.close();
        });
        HBox okBox = new HBox();
        okBox.getChildren().add(ok);
        okBox.setAlignment(Pos.CENTER);
        okBox.setPadding(marginlessInsets);
        middle.getChildren().add(okBox);
        middle.setPadding(marginlessInsets);
        //Bottom
        Button closeButton = new Button(closeButtonString);
        closeButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox closeButtonBox = new HBox();
        closeButtonBox.getChildren().add(closeButton);
        closeButtonBox.setAlignment(Pos.CENTER);
        closeButtonBox.setPadding(marginlessInsets);
        //Adding it all together.
        newReadPane.setCenter(middle);
        newReadPane.setBottom(closeButtonBox);
        Scene scene = new Scene(newReadPane, 300, 100);
        dialogStage.setScene(scene);
        dialogStage.setTitle(newReadText);
        dialogStage.setResizable(false);
        dialogStage.show();
    }

    void newCode() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        BorderPane newReadPane = new BorderPane();
        //Middle
        VBox middle = new VBox();
        HBox middleBox = new HBox();
        HBox middleBox2 = new HBox();
        Text fileText = new Text(fileNameText);
        fileName = new TextField(fileTextFieldText);
        middleBox.getChildren().add(fileText);
        middleBox.getChildren().add(fileName);
        Text filePath = new Text(filePathText);
        filePathField = new TextField(filePathFieldText);
        Button browse = new Button(browseText);
        middleBox2.getChildren().add(filePath);
        middleBox2.getChildren().add(filePathField);
        middleBox2.getChildren().add(browse);
        middleBox.setSpacing(10.0);
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setPadding(marginlessInsets);
        middleBox2.setAlignment(Pos.CENTER);
        middleBox2.setPadding(marginlessInsets);
        middle.getChildren().add(middleBox);
        middle.getChildren().add(middleBox2);
        Button ok = new Button(okText);
        ok.setOnAction((ActionEvent event) -> {
            eventHandler.respondToButtonPress("newCode");
            dialogStage.close();
        });
        HBox okBox = new HBox();
        okBox.getChildren().add(ok);
        okBox.setAlignment(Pos.CENTER);
        middle.getChildren().add(okBox);
        //Bottom
        Button closeButton = new Button(closeButtonString);
        closeButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox closeButtonBox = new HBox();
        closeButtonBox.getChildren().add(closeButton);
        closeButtonBox.setAlignment(Pos.CENTER);
        closeButtonBox.setPadding(marginlessInsets);
        //Adding it all together.
        newReadPane.setCenter(middle);
        newReadPane.setBottom(closeButtonBox);
        Scene scene = new Scene(newReadPane, 300, 135);
        dialogStage.setScene(scene);
        dialogStage.setTitle(newReadText);
        dialogStage.setResizable(false);
        dialogStage.show();
    }

    String getFileName() {
        CharSequence chars = fileName.getCharacters();
        return chars.toString();
    }

    String getFilePath() {
        CharSequence chars = fileName.getCharacters();
        return chars.toString();
    }

    void displayRead(String read) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        BorderPane exitPane = new BorderPane();
        Button okButton = new Button(okText);
        okButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox okBox = new HBox();
        okBox.getChildren().add(okButton);
        okBox.setSpacing(10.0);
        okBox.setAlignment(Pos.CENTER);
        okBox.setPadding(marginlessInsets);
        Text text = new Text(read);
        exitPane.setBottom(okBox);
        exitPane.setCenter(text);
        Scene scene = new Scene(exitPane, 200, 100);
        dialogStage.setScene(scene);
        dialogStage.setTitle(codeReadText);
        dialogStage.setResizable(false);
        dialogStage.show();
    }

    void showInvalidFileBox() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        BorderPane exitPane = new BorderPane();
        Button okButton = new Button(okText);
        okButton.setOnAction((ActionEvent event) -> {
            dialogStage.close();
        });
        HBox okBox = new HBox();
        okBox.getChildren().add(okButton);
        okBox.setSpacing(10.0);
        okBox.setAlignment(Pos.CENTER);
        okBox.setPadding(marginlessInsets);
        Text text = new Text(invalidFileText);
        exitPane.setBottom(okBox);
        exitPane.setCenter(text);
        Scene scene = new Scene(exitPane, 200, 100);
        dialogStage.setScene(scene);
        dialogStage.setTitle(invalidFileTitle);
        dialogStage.setResizable(false);
        dialogStage.show();
    }

}
