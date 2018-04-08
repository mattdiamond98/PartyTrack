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
        //ImageIO.write(qrCode, "PNG", new File("hello-world.png"));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            decode(qrCode);
            System.out.println("Failed to find QR Code.");
            return null;
        }
    }
}
