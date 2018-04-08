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
 * Author Jordan Goldstein
 * With help from callicoder.com
 */
public class OtherReader {

    public static String decode(File qrCode) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCode);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
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
