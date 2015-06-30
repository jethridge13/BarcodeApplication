/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barcodeapplication;

/**
 *
 * @author Joshua
 */
class BarcodeEventHandler {
    
    private BarcodeUI ui;

    BarcodeEventHandler(BarcodeUI initUI) {
        ui = initUI;
    }

    void respondToButtonPress(String button) {
        switch(button){
            case "Create New Code":
                //System.out.println("Create new code...");
                ui.newCode();
                break;
            case "Read New Code":
                //System.out.println("Reading a new code...");
                ui.newRead();
                break;
            case "Exit":
                //System.out.println("Exiting...");
                ui.exit();
                break;
        }
    }
    
}
