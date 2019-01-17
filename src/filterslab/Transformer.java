package filterslab;

import org.opencv.core.Mat;

/**
 *
 * @author Darag
 */
public interface Transformer {

    public Mat transform(Mat image);

}
