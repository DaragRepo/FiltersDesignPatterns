package filterslab;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class Blur implements Filter {

    @Override
    public Mat applyFilter(Mat image) {

        Mat mat = new Mat();
        Imgproc.blur(image, mat, new Size(4.0, 4.0));

        return mat;
    }

}
