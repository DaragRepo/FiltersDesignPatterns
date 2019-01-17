package filterslab;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Darag
 */
public class ImageHelpers {

    private static Image toBufferedImage(Mat matrix) {
        int type = BufferedImage.TYPE_BYTE_GRAY;// Gray levels 
        if (matrix.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;// RGB 
        }
        int bufferSize = (int) (matrix.total() * matrix.elemSize());//number of bytes in image (total number of pixils * size of pixil )
        byte[] buffer = new byte[bufferSize];
        matrix.get(0, 0, buffer); // row , col , byte[] we use it to copy the matrix content in our newely created byte[] array
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.
                rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().
                getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);

        return image;
    }

    public static Mat openFile(String fileName) throws Exception {

        Mat newImage = Imgcodecs.imread(fileName, Imgcodecs.IMREAD_COLOR);
        if (newImage.dataAddr() == 0) {
            throw new Exception("Couldn't open file " + fileName);
        }
        return newImage;
    }

    public static Image getImageFiltered(Filter filter, Mat image) {
        Mat img = filter.applyFilter(image);
        Image loadedImage = toBufferedImage(img);
        return loadedImage;
    }

    public static Image getImageTransformered(Transformer transformer, Mat image) {
        Mat img = transformer.transform(image);
        Image loadedImage = toBufferedImage(img);
        return loadedImage;
    }

    public static Image getImage(Mat image) {
        Image loadedImage = toBufferedImage(image);
        return loadedImage;
    }

}
