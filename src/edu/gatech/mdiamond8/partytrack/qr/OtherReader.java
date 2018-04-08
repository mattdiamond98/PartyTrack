package edu.gatech.mdiamond8.partytrack.qr;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Reads a QRCcode
 *
 * @author Jordan Goldstein
 * With help from callicoder.com
 */
public class OtherReader {
    /**
     * Decodes a String fromm a qrcode image
     * @param qrCode the qrCode image
     * @return the decoded qrcode
     * @throws IOException if there is no qrcode
     */
    public static String decode(BufferedImage qrCode) throws IOException {
        int i = 0;
        while (i < 10000) {
            LuminanceSource source = new BufferedImageLuminanceSource(qrCode);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                Result result = new MultiFormatReader().decode(bitmap);
                return result.getText();
            } catch (NotFoundException e) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    System.out.println("Thread timed out.");
                }
                i++;
                qrCode = QRImage.getImage();
                System.out.println("Failed to find QR Code.");
            }
        }

        return null;
    }
}
