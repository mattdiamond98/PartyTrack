package edu.gatech.mdiamond8.partytrack.qr;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

/**
 * Get image from webcam.
 *
 * @author Matthew Sklar
 */
public class QRImage {
    /**
     * Get an image from the webcam.
     *
     * @return the image from the webcam
     */
    public static BufferedImage getImage() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        return webcam.getImage();
    }
}
