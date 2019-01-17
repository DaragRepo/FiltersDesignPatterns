package filterslab;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Darag
 */
public class Gray implements Filter {

    @Override
    public Mat applyFilter(Mat src) {

        Mat des = new Mat();
        Imgproc.cvtColor(src, des, Imgproc.COLOR_RGB2GRAY);

        return des;
    }

}
