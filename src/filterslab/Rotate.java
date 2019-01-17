package filterslab;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class Rotate implements Transformer {

    @Override
    public Mat transform(Mat image) {
        Mat des = new Mat();
        Imgproc.warpAffine(image, des, Imgproc.getRotationMatrix2D(new Point(image.width() / 2, image.height() / 2), 270, 2), new Size(image.width(), image.height()));
        return des;
    }

}
