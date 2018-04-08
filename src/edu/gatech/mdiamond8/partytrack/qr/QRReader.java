package edu.gatech.mdiamond8.partytrack.qr;

import OnBarcode.Barcode.BarcodeScanner.BarcodeScanner;
import OnBarcode.Barcode.BarcodeScanner.BarcodeType;

public class QRReader {
    public QRReader() {

    }

    public void readBarcode(String file) {
        String[] barcodes = BarcodeScanner.Scan(file, BarcodeType.QRCode);


        for (String s : barcodes) {
            System.out.println(s);
        }
    }
}
