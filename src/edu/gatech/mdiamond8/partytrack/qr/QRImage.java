package edu.gatech.mdiamond8.partytrack.qr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;

/**
 * Get image from webcam.
 *
 * @author Matthew Sklar
 */
public class QRImage {
    public BufferedImage getImage() throws IOException {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        return webcam.getImage();
    }
}
