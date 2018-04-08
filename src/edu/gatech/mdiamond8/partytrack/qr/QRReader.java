package edu.gatech.mdiamond8.partytrack.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

/**
 * Reads a QRCcode
 *
 * Creates a seperate thread to run the scan.
 *
 * @author Jordan Goldstein
 * @author Matthew Sklar
 * With help from callicoder.com
 */
public class QRReader implements Runnable {
    /**
     * Four Jamaican bobsledders dream of competing in the Winter Olympics, despite never having seen snow. With the
     * help of a disgraced former champion desperate to redeem himself, the Jamaicans set out to become worthy of
     * Olympic selection, and go all out for glory.
     */
    public static volatile boolean coolRunning;

    private Thread t;
    private BufferedImage qrCode;
    private Consumer<String> function;

    /**
     * Constructor for QRReader.
     *
     * @param function function to apply the QR code to
     */
    public QRReader(Consumer<String> function) {
        this.function = function;
    }

    /**
     * Start running the thread.
     */
    public void start() {
        if (t == null) {
            coolRunning = true;
            t = new Thread(this, "Thread Decode");
            t.start();
        }
    }

    /**
     * Decodes a String fromm a qrcode image
     *
     * @throws NotFoundException if the result is not found
     * @throws InterruptedException if the thread times out
     */
    @Override
    public void run() {
        while (coolRunning) {
            qrCode = QRImage.getImage();

            LuminanceSource source = new BufferedImageLuminanceSource(qrCode);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                Result result = new MultiFormatReader().decode(bitmap);

                function.accept(result.getText());
            } catch (NotFoundException ex) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException exe) {
                    System.out.println("Thread timed out.");
                }
            }
        }
    }
}
