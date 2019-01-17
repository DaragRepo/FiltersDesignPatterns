package filterslab;

import javax.swing.JOptionPane;
import org.opencv.core.Core;

/**
 *
 * @author Darag
 */
public class Filters {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) throws Exception {
        Filter filters[] = {new GaussianBlur(), new Blur(), new Median(), new Gray(), new HistogramEqualization()};
        Transformer transformer[] = {new Scale(), new Rotate()};
        MainFrame.getInstance(600, 400, "GUI", "C:\\Users\\moh\\Desktop\\opencvTut\\image.jpg", filters, transformer);
//        int numberOfFilters = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter number of filters"));
//        Filter filters[] = new Filter[numberOfFilters];
//        for (int i = 0; i < filters.length; i++) {
//            String s = JOptionPane.showInputDialog(null, "Enter The Name of The " + (i + 1) + " filter");
//            Class<?> clazz = Class.forName("filterslab." + s);
//            filters[i] = (Filter) clazz.newInstance();
//        }
//        new MainFrame(600, 400, "GUI", "C:\\Users\\moh\\Desktop\\opencvTut\\image.jpg", filters, transformer);

    }
}
