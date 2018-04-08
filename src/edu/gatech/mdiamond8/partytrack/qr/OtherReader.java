package edu.gatech.mdiamond8.partytrack.qr;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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
        LuminanceSource source = new BufferedImageLuminanceSource(qrCode);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the Image");
            return null;
        }
    }
}
