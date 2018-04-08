package edu.gatech.mdiamond8.partytrack.qr;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

/**
 * Get image from webcam.
 *
 * @author Matthew Sklar
 */
public class QRImage {
    public static BufferedImage getImage() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        return webcam.getImage();
    }
}
