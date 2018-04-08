package edu.gatech.mdiamond8.partytrack.qr;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

/**
 * Takes image of QR Code.
 *
 * @author Matthew Sklar
 */
public class Image {
 /*   private Mat mat;
    private BufferedImage img;

    static {
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public Image() {
        mat = new Mat();
    }

    public void getSpace() {
        int type = 0;
        if (mat.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if (mat.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        this.mat = mat;
        int w = mat.cols();
        int h = mat.rows();
        if (img == null || img.getWidth() != w || img.getHeight() != h || img.getType() != type)
            img = new BufferedImage(w, h, type);
    }

    public BufferedImage getImage() {
        getSpace();
        WritableRaster raster = img.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        mat.get(0, 0, data);
        return img;
    }*/
}
