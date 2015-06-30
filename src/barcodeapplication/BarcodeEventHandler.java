/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcodeapplication;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        try {
            switch (button) {
                case "Create New Code":
                    //System.out.println("Create new code...");
                    ui.newCode();
                    break;
                case "newCode":
                    createNewCode();
                    break;
                case "newRead":
                    createNewRead();
                case "Read New Code":
                    //System.out.println("Reading a new code...");
                    ui.newRead();
                    break;
                case "Exit":
                    //System.out.println("Exiting...");
                    ui.exit();
                    break;
            }
        } catch (IOException | NotFoundException ex) {
            ui.showInvalidFileBox();
        }
    }

    private void createNewCode() {
        String fileName = ui.getFileName();
        String filePath = ui.getFilePath();
    }

    private void createNewRead() throws IOException, NotFoundException {
        String fileName = ui.getFileName();
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(fileName)))));
        Result codeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
        //System.out.println("Code read!");
        ui.displayRead(codeResult.getText());
        //return codeResult.getText();
    }

    private static String ensureBitmap(String filePath) {
        if (!filePath.endsWith(".bmp")) {
            filePath += ".bmp";
        }
        return filePath;
    }

}
