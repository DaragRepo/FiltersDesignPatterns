package filterslab;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class GaussianBlur implements Filter {

    @Override
    public Mat applyFilter(Mat image) {

        Mat mat = new Mat();
        Imgproc.GaussianBlur(image, mat, new Size(7.0, 7.0), 0);

        return mat;
    }

}
