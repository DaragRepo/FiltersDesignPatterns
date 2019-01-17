package filterslab;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class Median implements Filter {

    @Override
    public Mat applyFilter(Mat image) {

        Mat mat = new Mat();
        Imgproc.medianBlur(image, mat, 55);

        return mat;
    }

}
