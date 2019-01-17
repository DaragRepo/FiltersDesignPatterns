package filterslab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;

/**
 *
 * @author Darag
 */
public class MainFrame extends JFrame {

    private MyPanel panel;
    private TransformerPanel transformerPanel;
    private static JLabel image = new JLabel("");
    private static Mat getImage;
    private static Filter filter[];
    private static Transformer transformer[];
    private static MainFrame mySingleton = null;

    private MainFrame(int width, int height, String frameName, String imagePath, Filter filter[], Transformer transformer[]) throws Exception {

        super(frameName);
        getImage = ImageHelpers.openFile(imagePath);
        setImage();
        MainFrame.filter = filter;
        MainFrame.transformer = transformer;
        panel = new MyPanel();
        transformerPanel = new TransformerPanel();
        add(panel, BorderLayout.NORTH);
        add(transformerPanel, BorderLayout.SOUTH);
        panel.add(image, BorderLayout.CENTER);
        image.setHorizontalAlignment(JLabel.CENTER);
        image.setVerticalAlignment(JLabel.CENTER);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }
    
    public static void getInstance(int width, int height, String frameName, String imagePath, Filter filter[], Transformer transformer[]) throws Exception {

        if (mySingleton == null) {
            mySingleton = new MainFrame(width, height, frameName, imagePath, filter, transformer);
        }
    }
    
    

    public static Filter[] getFilter() {
        return MainFrame.filter;
    }

    public static Transformer[] getTransformer() {
        return MainFrame.transformer;
    }

    public static void setImageTransformed(Mat image, Transformer transformer) {
        MainFrame.image.setIcon(new ImageIcon(ImageHelpers.getImageTransformered(transformer, image)));
    }

    public static Mat getImage() {
        return getImage;
    }

    public static void setImage() {
        image.setIcon(new ImageIcon(ImageHelpers.getImage(getImage)));
    }

    public static void setImageFiltered(Mat image, Filter filter) {
        MainFrame.image.setIcon(new ImageIcon(ImageHelpers.getImageFiltered(filter, image).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
    }

}
