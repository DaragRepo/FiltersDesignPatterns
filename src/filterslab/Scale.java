package filterslab;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class Scale implements Transformer {

    @Override
    public Mat transform(Mat image) {
        Mat des = new Mat();
        Imgproc.resize(image, des, new Size(image.width() / 2, image.height() / 2));
        return des;

    }

}
